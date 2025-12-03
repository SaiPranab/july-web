package com.tastytown.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.service.IFoodService;
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
public class FoodController {
    private final ObjectMapper objectMapper;
    private final IFoodService foodService;

//    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<FoodResponseDTO> createFood( @RequestPart String foodData,
//                                                       @RequestPart MultipartFile foodImage)
//            throws JsonProcessingException, IOException {
//
//        FoodRequestDTO dto = objectMapper.readValue(foodData, FoodRequestDTO.class);
//
//        FoodResponseDTO responseDTO = foodService.createFood(dto, foodImage);
//
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<FoodResponseDTO> createFood( @RequestBody FoodRequestDTO dto){
        FoodResponseDTO responseDTO = foodService.createFood(dto);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/image/{foodId}/food", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> createFoodImage(@PathVariable String foodId,
                                                @RequestPart MultipartFile foodImage) throws IOException{
        foodService.createFoodImage(foodId, foodImage);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    extract a single food By Id

//    extract all the available foods

//    extract all foods with pagination & filteration & searching
    @GetMapping("/paginated-foods")
    public ResponseEntity<Page<FoodResponseDTO>> getPaginatedFoods(
            @RequestParam(required = false, defaultValue = "all") String categoryId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "12") int pageSize
    ) {
        return ResponseEntity.ok(foodService.getPaginatedFoods(categoryId, search, pageNumber, pageSize));
    }

//    extract a single food image


//    full update a single food using put mapping
    @PutMapping(value = "/{foodId}")
    public ResponseEntity<FoodResponseDTO> updateFoodFull(
            @PathVariable String foodId,
            @RequestBody FoodRequestDTO dto
    ){
        FoodResponseDTO updated =foodService.updateFoodFull(foodId, dto);
        return ResponseEntity.ok(updated);
    }

//      partial update a single food using patch mapping
    @PatchMapping(value = "/{foodId}")
    public ResponseEntity<FoodResponseDTO> updateFoodPartial(
            @PathVariable String foodId,
            @RequestBody Map<String, Object> updates
    ) throws IOException{
        FoodResponseDTO updated = foodService.updateFoodPartial(foodId, updates);
        return ResponseEntity.ok(updated);
    }

// extract all foods
    @GetMapping
    public ResponseEntity<List<FoodResponseDTO>> getAllFoods(){
        return  ResponseEntity.ok(foodService.getAllFoods());
    }
// extract food by id

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodResponseDTO> getSingleFoodById(@PathVariable String foodId){
        return  ResponseEntity.ok(foodService.getSingleFoodById(foodId));
    }








}
