package com.tastytown.backend.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.service.ICategoryService;
// import com.tastytown.backend.service.impl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@Tag(name = "Tasty-Town API",description = "This Controller manages CRUD operations for food order")
public class CategoryController {
    private final ICategoryService service;

    @Operation(summary="Get all food Category",description = "Fetch all food category")
    @GetMapping("/")
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/{catId}")
    public Category getCategoryById(@PathVariable String catId) {
        return service.getCategoryById(catId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary="Creates a new Food Category")
    @ApiResponse(description = "Food Category validation failed",responseCode = "422")
    public Category addCategory(@RequestBody Category cat) {
        return service.addCategory(cat);
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return service.updateCategory(updatedCategory);
    }

    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCategory(@PathVariable String catId) {
        service.deleteCategory(catId);
    }
}

