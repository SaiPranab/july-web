package com.tastytown.backend.service;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFoodService {
    FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage) throws IOException;
}
