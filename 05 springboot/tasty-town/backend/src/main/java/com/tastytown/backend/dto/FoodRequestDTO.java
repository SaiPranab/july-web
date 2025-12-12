package com.tastytown.backend.dto;

import jakarta.validation.constraints.*;

public record FoodRequestDTO(

        @NotBlank(message = "Food name is required")
        @NotEmpty
        @NotNull
        String foodName,

        @NotBlank(message = "Food description is required")
        @Size(max = 500, message = "Food description must be less than 500 characters")
        String foodDescription,


        @Digits(integer = 5,fraction = 2)
        @PositiveOrZero
        Double foodPrice,


        @NotBlank(message = "Category ID is required")
        @NotNull
        @NotBlank
        String categoryId
) {
}