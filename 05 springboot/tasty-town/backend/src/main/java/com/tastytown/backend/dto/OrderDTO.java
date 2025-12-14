package com.tastytown.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        String orderId,
        List<OrderItemDTO> orderItems,
        double totalAmount,
        String orderStatus,
        LocalDateTime orderDate,
        String contactInfo,
        String addressInfo
) {
}
