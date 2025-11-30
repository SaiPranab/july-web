package com.tastytown.backend.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.service.ICategoryService;
// import com.tastytown.backend.service.impl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final ICategoryService service;

    @GetMapping("/")
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/{catId}")
    public Category getCategoryById(@PathVariable String catId) {
        return service.getCategoryById(catId);
    }

    @PostMapping("/")
    public Category addCategory(@RequestBody Category cat) {
        return service.addCategory(cat);
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return service.updateCategory(updatedCategory);
    }

    @DeleteMapping("/{catId}")
    public void deleteCategory(@PathVariable String catId) {
        service.deleteCategory(catId);
    }
}

