package com.tastytown.backend.dto;

import com.tastytown.backend.constants.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        String orderId,
        List<OrderItemDTO> orderItems,
        double totalAmount,
        OrderStatus orderStatus,
        LocalDateTime orderDate,
        String contactInfo,
        String addressInfo
) {
}
