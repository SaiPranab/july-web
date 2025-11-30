package com.tastytown.backend.service.impl;

import java.util.List;
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
        return categoryRepository.findById(catId).orElseThrow();
    }

    public Category addCategory(Category cat) {
        return categoryRepository.save(cat);
    }

    public Category updateCategory(Category updatedCategory) {
        return categoryRepository.save(updatedCategory);
    }

    public void deleteCategory(String catId) {
        categoryRepository.deleteById(catId);
    }
}
