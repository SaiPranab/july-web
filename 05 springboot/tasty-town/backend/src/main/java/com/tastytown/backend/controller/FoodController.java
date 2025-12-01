package com.tastytown.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
public class FoodController {
    private final ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<FoodResponseDTO> createFood( @RequestPart String foodData,
                                                       @RequestPart MultipartFile foodImage) throws JsonProcessingException {
        FoodRequestDTO dto = objectMapper.readValue(foodData, FoodRequestDTO.class);
//        foodService.createFood(dto, foodImage);

        return ResponseEntity.ok(null);
    }
}
