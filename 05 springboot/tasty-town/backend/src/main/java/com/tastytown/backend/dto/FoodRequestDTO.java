package com.tastytown.backend.dto;

public record FoodRequestDTO(
        String foodName,
        String foodDescription,
        Double foodPrice,
        String categoryId
) {
}
