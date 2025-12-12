package com.tastytown.backend.dto;

import jakarta.validation.constraints.*;

public record FoodRequestDTO(

        @NotBlank(message = "Food name is required")
        @NotEmpty(message = "Food name is required")
        @NotNull(message = "Food name cannot be null")
        String foodName,

        @NotBlank(message = "Food description is required")
        @Size(max = 100, message = "Food description must be less than 500 characters")
        String foodDescription,


        @Digits(integer = 5,fraction = 2)
        @PositiveOrZero
        Double foodPrice,


        @NotBlank(message = "Category ID is required")
        @NotNull(message = "Category Id is required")
        @NotBlank(message = "Category Id cannot be blank ")
        String categoryId
) {
}