package com.tastytown.backend.controller;

import java.util.List;

import com.tastytown.backend.dto.CategoryRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.tastytown.backend.model.Category;
import com.tastytown.backend.service.ICategoryService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@Tag(name = "Category API", description = "A controller manages the CRUD operations for Categories.")
public class CategoryController {
    private final ICategoryService service;


    @Operation(summary = "Get all Categories", description = "Retrieves a list of all categories.")
    @ApiResponse(description = "Successfully retrieved categories", responseCode = "200")
    @GetMapping
    public List<Category> getCategories() {
        return service.getCategories();
    }

    @Operation(summary = "Get a Category by ID", description = "Retrieves a specific category by its ID.")
    @ApiResponse(description = "Category found successfully", responseCode = "200")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @GetMapping("/{catId}")
    public Category getCategoryById(@PathVariable String catId) {
        return service.getCategoryById(catId);
    }

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new Category", description = "Adds a new category to the system.")
    @ApiResponse(description = "Category created successfully", responseCode = "201")
    @ApiResponse(description = "Category validation failed (e.g., missing data)", responseCode = "422")
    public Category addCategory(@RequestBody CategoryRequestDTO cat) {
        return service.addCategory(cat);
    }

    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Updates an existing Category", description = "Performs a full update on the category identified in the request body.")
    @ApiResponse(description = "Category updated successfully", responseCode = "200")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @PutMapping
    public Category updateCategory(@RequestBody Category updatedCategory) {
        return service.updateCategory(updatedCategory);
    }

    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Deletes a Category by ID", description = "Removes the category identified by its ID.")
    @ApiResponse(description = "Category deleted successfully (No Content)", responseCode = "204")
    @ApiResponse(description = "Category not found", responseCode = "404")
    @DeleteMapping("/{catId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable String catId) {
        service.deleteCategory(catId);
    }
}