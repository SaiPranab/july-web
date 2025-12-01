package com.tastytown.backend.service.impl;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.model.Category;
import com.tastytown.backend.repository.FoodRepository;
import com.tastytown.backend.service.ICategoryService;
import com.tastytown.backend.service.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {
    private final FoodRepository foodRepository;
    private final ICategoryService categoryService;

    @Override
    public FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage) {
        Category category = categoryService.getCategoryById(dto.categoryId());

//        upload image in folder
        String newImageName = uploadImage(foodImage);

//        save food information in database
        return null;
    }

    private String uploadImage(MultipartFile foodImage) {

        return "";
    }
}
