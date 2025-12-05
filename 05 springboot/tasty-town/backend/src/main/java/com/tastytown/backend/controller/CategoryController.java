package com.tastytown.backend.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@Tag(name = "Tasty-Town Food Category API", description = "A controller manages the CRUD operations for Food Categories.")
public class CategoryController {
    private final ICategoryService service;

    @Operation(summary = "Get all food Categories")
    @ApiResponse(description = "Successfully retrieved categories", responseCode = "200")
    @GetMapping
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @Operation(summary = "Get a food Category by ID")
    @ApiResponse(description = "Category found successfully", responseCode = "200")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @GetMapping("/{catId}")
    public Category getCategoryById(@PathVariable String catId) {
        return service.getCategoryById(catId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new Food Category")
    @ApiResponse(description = "Food Category created successfully", responseCode = "201")
    @ApiResponse(description = "Food Category validation failed (e.g., missing data)", responseCode = "422")
    public Category addCategory(@RequestBody Category cat) {
        return service.addCategory(cat);
    }

    @Operation(summary = "Updates an existing Food Category")
    @ApiResponse(description = "Category updated successfully", responseCode = "200")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @PutMapping
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return service.updateCategory(updatedCategory);
    }

    @Operation(summary = "Deletes a Food Category by ID")
    @ApiResponse(description = "Category deleted successfully (No Content)", responseCode = "204")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Changed from ACCEPTED to NO_CONTENT for common REST practice
    public void deleteCategory(@PathVariable String catId) {
        service.deleteCategory(catId);
    }
}