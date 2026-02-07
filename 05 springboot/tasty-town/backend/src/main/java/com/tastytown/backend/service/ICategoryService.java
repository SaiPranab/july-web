package com.tastytown.backend.service;

import java.util.List;

import com.tastytown.backend.dto.CategoryRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tastytown.backend.model.Category;

public interface ICategoryService {
    List<Category> getCategories();

    Category getCategoryById(@PathVariable String catId);

    Category addCategory(@RequestBody CategoryRequestDTO cat);

    Category updateCategory(@RequestBody Category updatedCategory);

    void deleteCategory(@PathVariable String catId);
}
