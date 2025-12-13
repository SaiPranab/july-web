package com.tastytown.backend.dto;

public record CartItemResponseDTO(
        String foodId,
        int quantity,
        String foodName,
        String foodCategoryName,
        double foodPrice
) {
}
