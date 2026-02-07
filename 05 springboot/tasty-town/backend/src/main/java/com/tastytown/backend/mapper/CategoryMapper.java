package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.CategoryRequestDTO;

import com.tastytown.backend.model.Category;


public class CategoryMapper {
    private CategoryMapper(){}

    public static Category convertToCategory(CategoryRequestDTO dto) {
        Category newCategory = Category.builder()
                .categoryName(dto.categoryName())
                .build();

        return newCategory;
    }
}