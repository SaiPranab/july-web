package com.tastytown.backend.service.impl;

import com.tastytown.backend.constants.OrderStatus;
import com.tastytown.backend.dto.BillingInfoDTO;
import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.mapper.OrderMapper;
import com.tastytown.backend.model.*;
import com.tastytown.backend.repository.CartRepository;
import com.tastytown.backend.repository.OrderRepository;
import com.tastytown.backend.service.ICartService;
import com.tastytown.backend.service.IOrderService;
import com.tastytown.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final IUserService userService;
    private final ICartService cartService;

    @Override
    public OrderDTO createOrder(String userId, BillingInfoDTO billingInfo) {
        UserEntity user = userService.getUserById(userId);

        Cart cartOfUser = cartService.getCartOfAnUser(user);

        if(cartOfUser.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUser(user);
        orderEntity.setOrderDate(LocalDateTime.now());
        orderEntity.setOrderStatus(OrderStatus.FOOD_PREPARING);
        orderEntity.setContactInfo(getContactInfo(billingInfo));
        orderEntity.setAddressInfo(getAddressInfo(billingInfo));

        double totalAmount = 0;

        for(CartItem cartItem : cartOfUser.getItems()) {
            OrderItem item = OrderItem.builder()
                    .foodName(cartItem.getFood().getFoodName())
                    .foodPrice(cartItem.getFood().getFoodPrice())
                    .quantity(cartItem.getQuantity())
                    .order(orderEntity)
                    .build();
            orderEntity.getOrderItems().add(item);

            totalAmount += (cartItem.getFood().getFoodPrice() * cartItem.getQuantity());
        }

        orderEntity.setTotalAmount(totalAmount + 10 + ( totalAmount * 0.1));
        orderRepository.save(orderEntity);

        cartOfUser.getItems().clear();
        cartRepository.save(cartOfUser);

        return OrderMapper.convertToDTO(orderEntity);
    }

    @Override
    public List<OrderDTO> getOrdersOfAnUser(String userId) {
        UserEntity user = userService.getUserById(userId);

        List<OrderEntity> orders = orderRepository.
                findAllByUser(user, Sort.by(Direction.DESC, "orderDate"));

        return orders
                .stream()
                .map(OrderMapper :: convertToDTO)
                .toList();
    }

    @Override
    public List<OrderDTO> getAllOrders(String userId) {
        List<OrderEntity> orders = orderRepository.findAll(Sort.by(Direction.DESC, "orderDate"));

        return orders.stream().map(OrderMapper :: convertToDTO).toList();
    }

    @Override
    public OrderDTO updateOrderStatus(String orderId, OrderStatus status) {
        OrderEntity existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order Not Found"));

        existingOrder.setOrderStatus(status);
        OrderEntity updatedOrder = orderRepository.save(existingOrder);

        return OrderMapper.convertToDTO(updatedOrder);
    }

    private String getAddressInfo(BillingInfoDTO billingInfo) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(billingInfo.address());
        joiner.add(billingInfo.city());
        joiner.add(billingInfo.state());
        joiner.add(billingInfo.zip());

        return joiner.toString();
    }

    private String getContactInfo(BillingInfoDTO billingInfo) {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(billingInfo.fullName());
        joiner.add(billingInfo.email());
        joiner.add(billingInfo.phoneNumber());

        return joiner.toString();
    }
}
