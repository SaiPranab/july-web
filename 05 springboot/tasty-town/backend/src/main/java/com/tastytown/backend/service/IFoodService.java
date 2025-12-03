package com.tastytown.backend.service;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IFoodService {
//    FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage) throws IOException;

    FoodResponseDTO createFood(FoodRequestDTO dto);
    void createFoodImage(String foodId, MultipartFile foodImage) throws IOException;

    Page<FoodResponseDTO> getPaginatedFoods(String categoryId, String search, int pageNumber, int pageSize);

//    full update a single food using put mapping
    FoodResponseDTO updateFoodFull(String foodId, FoodRequestDTO dto);

//    partial update a single food using patch mapping
    FoodResponseDTO updateFoodPartial(String foodId, Map<String, Object> updates);

}
