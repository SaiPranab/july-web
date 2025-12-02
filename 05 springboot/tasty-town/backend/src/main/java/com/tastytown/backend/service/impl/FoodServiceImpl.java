package com.tastytown.backend.service.impl;

import com.tastytown.backend.dto.FoodRequestDTO;
import com.tastytown.backend.dto.FoodResponseDTO;
import com.tastytown.backend.mapper.FoodMapper;
import com.tastytown.backend.model.Category;
import com.tastytown.backend.model.Food;
import com.tastytown.backend.repository.FoodRepository;
import com.tastytown.backend.service.ICategoryService;
import com.tastytown.backend.service.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {
    private final FoodRepository foodRepository;
    private final ICategoryService categoryService;

    @Value("${upload.image.path}")
    private String IMAGES_FOLDER_PATH;

    @Override
    public FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage) throws IOException{
//        Check if category exists or not
        Category category = categoryService.getCategoryById(dto.categoryId());

//        upload image in folder
        String newImageName = uploadImage(foodImage);

//        convert dto to food
        Food food = FoodMapper.convertToFood(dto, category, newImageName);

//        save food information in database
        Food savedFood = foodRepository.save(food);

        return FoodMapper.convertToFoodResponseDTO(savedFood);
    }

    private String uploadImage(MultipartFile foodImage) throws IOException {
        if (foodImage == null || foodImage.isEmpty()) {
            throw new NoSuchElementException("Food image not found");
        }

        String fileName = foodImage.getOriginalFilename();
        String newFileName = getNewFileName(fileName);

        FileOutputStream outputStream = new FileOutputStream(IMAGES_FOLDER_PATH + File.separator + newFileName );
        outputStream.write(foodImage.getBytes());
        outputStream.close();

        return newFileName;
    }

    private String getNewFileName(String fileName) {
        String extensionName = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + System.currentTimeMillis();
        return newFileName + extensionName;
    }
}
