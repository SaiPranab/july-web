package com.tastytown.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.service.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
public class FoodController {
    private final ObjectMapper objectMapper;
    private final IFoodService foodService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FoodResponseDTO> createFood( @RequestPart String foodData,
                                                       @RequestPart MultipartFile foodImage)
            throws JsonProcessingException, IOException {

        FoodRequestDTO dto = objectMapper.readValue(foodData, FoodRequestDTO.class);

        FoodResponseDTO responseDTO = foodService.createFood(dto, foodImage);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
