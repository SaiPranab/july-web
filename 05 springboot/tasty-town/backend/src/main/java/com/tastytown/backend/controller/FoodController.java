package com.tastytown.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.service.IFoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
@Tag(name = "Tasty-Town Food API", description = "A controller manages the CRUD operations for Food entities.")
//@CrossOrigin("http://localhost:5173")
public class FoodController {
    private final ObjectMapper objectMapper;
    private final IFoodService foodService;

    @SecurityRequirement(name = "bearerAuth")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new Food entity", description = "Creates a new food item with the provided data.")
    @ApiResponse(description = "Food created successfully", responseCode = "201")
    @ApiResponse(description = "Food validation failed", responseCode = "422")
    @PostMapping
    public ResponseEntity<FoodResponseDTO> createFood( @RequestBody FoodRequestDTO dto){
        FoodResponseDTO responseDTO = foodService.createFood(dto);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "bearerAuth")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Uploads an image for a specific Food entity", description = "Uploads a new image for the food item identified by foodId.")
    @ApiResponse(description = "Food image uploaded successfully", responseCode = "204")
    @ApiResponse(description = "Food not found", responseCode = "404")
    @PostMapping(value = "/image/{foodId}/food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createFoodImage(@PathVariable String foodId,
                                                @RequestPart MultipartFile foodImage) throws IOException{
        foodService.createFoodImage(foodId, foodImage);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Retrieves all foods with pagination, filtering, and searching", description = "Returns a page of Food entities based on optional category, search term, page number, and page size.")
    @ApiResponse(description = "Successfully retrieved paginated foods", responseCode = "200")
    @GetMapping("/paginated-foods")
    public ResponseEntity<Page<FoodResponseDTO>> getPaginatedFoods(
            @RequestParam(required = false, defaultValue = "all", name = "catId") String categoryId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false, defaultValue = "0", name = "page") int pageNumber,
            @RequestParam(required = false, defaultValue = "12", name = "size") int pageSize
    ) {
        return ResponseEntity.ok(foodService.getPaginatedFoods(categoryId, search, pageNumber, pageSize));
    }


    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Performs a full update of a Food entity", description = "Replaces the entire Food entity with the new data provided in the request body.")
    @ApiResponse(description = "Food updated successfully", responseCode = "200")
    @ApiResponse(description = "Food not found", responseCode = "404")
    @PutMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> updateFoodFull(
            @PathVariable String foodId,
            @RequestBody FoodRequestDTO dto
    ){
        FoodResponseDTO updated =foodService.updateFoodFull(foodId, dto);
        return ResponseEntity.ok(updated);
    }


    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Performs a partial update of a Food entity", description = "Updates only the fields provided in the request body for the specified foodId.")
    @ApiResponse(description = "Food partially updated successfully", responseCode = "200")
    @ApiResponse(description = "Food not found", responseCode = "404")
    @PatchMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> updateFoodPartial(
            @PathVariable String foodId,
            @RequestBody Map<String, Object> updates
    ) throws IOException{
        FoodResponseDTO updated = foodService.updateFoodPartial(foodId, updates);
        return ResponseEntity.ok(updated);
    }


    @Operation(summary = "Retrieves all available foods", description = "Returns a list of all Food entities.")
    @ApiResponse(description = "Successfully retrieved all foods", responseCode = "200")
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAllFoods(){
        return  ResponseEntity.ok(foodService.getAllFoods());
    }


    @Operation(summary = "Retrieves a single food by ID", description = "Returns a specific Food entity identified by its ID.")
    @ApiResponse(description = "Food found successfully", responseCode = "200")
    @ApiResponse(description = "Food not found", responseCode = "404")
    @GetMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> getSingleFoodById(@PathVariable String foodId){
        return  ResponseEntity.ok(foodService.getSingleFoodById(foodId));
    }

    @Operation(summary = "Retrieves a food image by its name", description = "Returns the image file as a byte array for the given image name.")
    @ApiResponse(description = "Image retrieved successfully", responseCode = "200")
    @ApiResponse(description = "Image not found", responseCode = "404")
    @GetMapping("/{imageName}/image")
    public ResponseEntity<byte[]> getFoodImageByName(@PathVariable String imageName) throws IOException {
        byte[] image = foodService.getFoodImageByImageName(imageName);

        String contentType;
        if(imageName.contains(".jpg") || imageName.contains(".jpeg")) {
            contentType = MediaType.IMAGE_JPEG_VALUE;
        } else if(imageName.contains(".png")) {
            contentType = MediaType.IMAGE_PNG_VALUE;
        } else {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(image);
    }


}