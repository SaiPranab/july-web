package com.tastytown.backend.service.impl;

import java.util.List;

import com.tastytown.backend.dto.CategoryRequestDTO;
import com.tastytown.backend.exception.CategoryNotFoundException;
import com.tastytown.backend.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.repository.CategoryRepository;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(String catId) {
        return categoryRepository.findById(catId).orElseThrow(()-> new CategoryNotFoundException("category not found in this id" + catId));
    }

    public Category addCategory(CategoryRequestDTO catDto) {
        Category category = CategoryMapper.convertToCategory(catDto);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category updatedCategory) {
        return categoryRepository.save(updatedCategory);
    }

    public void deleteCategory(String catId) {
        categoryRepository.deleteById(catId);
    }
}
