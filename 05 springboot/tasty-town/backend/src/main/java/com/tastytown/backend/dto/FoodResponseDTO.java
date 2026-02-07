package com.tastytown.backend.dto;

public record FoodResponseDTO(
        String foodId,
        String foodName,
        String foodDescription,
        double foodPrice,
        String foodImage,
        String categoryId,
        String categoryName
) {
//    Works like a Immuatbale Object
//    by default all the fields are private & final
//    by default provide getters for all the fields
//    provide a all args constructor
//   overrides hashcode & equals() for object comparison
//    overrides the toString()
}
