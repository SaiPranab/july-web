package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.dto.OrderItemDTO;
import com.tastytown.backend.model.OrderEntity;

import java.util.List;

public class OrderMapper {
    private OrderMapper() {}

    public static OrderDTO convertToDTO(OrderEntity order) {
        List<OrderItemDTO> items = order.getOrderItems()
                .stream()
                .map(orderItem ->
                        new OrderItemDTO(orderItem.getFoodName(),
                                orderItem.getFoodPrice(),
                                orderItem.getQuantity())
                )
                .toList();

        OrderDTO orderDTO = new OrderDTO(
                order.getOrderId(),
                items,
                order.getTotalAmount(),
                order.getOrderStatus(),
                order.getOrderDate(),
                order.getContactInfo(),
                order.getAddressInfo()
        );

        return orderDTO;
    }
}
