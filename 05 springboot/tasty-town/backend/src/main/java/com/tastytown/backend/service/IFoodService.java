package com.tastytown.backend.service;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IFoodService {
    FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage);
}
