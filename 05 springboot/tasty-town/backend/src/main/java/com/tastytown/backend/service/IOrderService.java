package com.tastytown.backend.service;


import com.tastytown.backend.constants.OrderStatus;
import com.tastytown.backend.dto.BillingInfoDTO;
import com.tastytown.backend.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO createOrder(String userId, BillingInfoDTO billingInfo);

    OrderDTO getOrdersOfAnUser(String userId);

    List<OrderDTO> getAllOrders(String userId);

    OrderDTO updateOrderStatus(String orderId, OrderStatus status);
}
