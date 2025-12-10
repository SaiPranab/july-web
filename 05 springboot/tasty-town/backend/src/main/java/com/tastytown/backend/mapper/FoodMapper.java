package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.model.Category;
import com.tastytown.backend.model.Food;

public class FoodMapper {
    private FoodMapper(){}

    public static Food convertToFood(FoodRequestDTO dto, Category category, String imageName) {
        Food newFood = Food.builder()
                .foodName(dto.foodName())
                .foodDescription(dto.foodDescription())
                .foodPrice(dto.foodPrice())
                .category(category)
//                add food image here
                .foodImage(imageName)
                .build();

        return newFood;
    }

    public static FoodResponseDTO convertToFoodResponseDTO(Food food) {
        FoodResponseDTO dto = new FoodResponseDTO(
                food.getFoodId(),
                food.getFoodName(),
                food.getFoodDescription(),
                food.getFoodPrice(),
                food.getFoodImage(),
                food.getCategory().getCategoryId(),
                food.getCategory().getCategoryName()
        );

        return dto;
    }
}
