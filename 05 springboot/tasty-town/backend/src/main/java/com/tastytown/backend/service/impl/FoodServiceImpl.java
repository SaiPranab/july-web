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
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {
    private final FoodRepository foodRepository;
    private final ICategoryService categoryService;

    @Value("${upload.image.path}")
    private String IMAGES_FOLDER_PATH;

//    @Override
//    public FoodResponseDTO createFood(FoodRequestDTO dto, MultipartFile foodImage) throws IOException{
////        Check if category exists or not
//        Category category = categoryService.getCategoryById(dto.categoryId());
//
////        upload image in folder
//        String newImageName = uploadImage(foodImage);
//
////        convert dto to food
//        Food food = FoodMapper.convertToFood(dto, category, newImageName);
//
////        save food information in database
//        Food savedFood = foodRepository.save(food);
//
//        return FoodMapper.convertToFoodResponseDTO(savedFood);
//    }

    @Override
    public FoodResponseDTO createFood(FoodRequestDTO dto){
//        Check if category exists or not
        Category category = categoryService.getCategoryById(dto.categoryId());

//        convert dto to food
        Food food = FoodMapper.convertToFood(dto, category, null);

    //        save food information in database
        Food savedFood = foodRepository.save(food);

        return FoodMapper.convertToFoodResponseDTO(savedFood);
    }

    public void createFoodImage(String foodId, MultipartFile foodImage) throws IOException{
//        Check if food exists or not
        Food existingFood = getFoodById(foodId);

//        upload image
        String newImageName = uploadImage(foodImage);
        existingFood.setFoodImage(newImageName);

//        save food information in database
        foodRepository.save(existingFood);
    }

    @Override
    public Page<FoodResponseDTO> getPaginatedFoods(String categoryId, String search,
                                                   int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Food> paginatedFoods = null;

        if(!categoryId.equals("all") && search != null) {
            paginatedFoods = foodRepository.findAllByCategory_CategoryIdAndFoodNameContainingIgnoreCase(categoryId, search, pageable);
        } else if (!categoryId.equals("all")) {
            paginatedFoods = foodRepository.findAllByCategory_CategoryId(categoryId, pageable);
        } else if(search != null) {
            paginatedFoods = foodRepository.findAllByFoodNameContainingIgnoreCase(search, pageable);
        } else {
            paginatedFoods = foodRepository.findAll(pageable);
        }

        Page<FoodResponseDTO> paginatedDTOs = paginatedFoods.map(food ->
                FoodMapper.convertToFoodResponseDTO(food));
        return paginatedDTOs;
    }

//    full update a single food using put mapping
    @Override
    public FoodResponseDTO updateFoodFull(String foodId, FoodRequestDTO dto) {
        Food existingFood = foodRepository.findById(foodId)
                .orElseThrow(() -> new NoSuchElementException("Food Not Found !!!"));

        Category category = categoryService.getCategoryById(dto.categoryId());

        existingFood.setFoodName(dto.foodName());
        existingFood.setFoodDescription(dto.foodDescription());
        existingFood.setFoodPrice(dto.foodPrice());

        existingFood.setCategory(category);

        Food updatedFood = foodRepository.save(existingFood);
        return FoodMapper.convertToFoodResponseDTO(updatedFood);

    }

//    partial update a single food using patch mapping
    @Override
    public FoodResponseDTO updateFoodPartial(String foodId, Map<String, Object> updates) {
       Food existingFood = foodRepository.findById(foodId)
                .orElseThrow(() -> new NoSuchElementException("No Suchn Food Found !!!"));

       if (updates.containsKey("foodName")) existingFood.setFoodName(String.valueOf(updates.get("foodName")));
       if (updates.containsKey("foodDescription")) existingFood.setFoodDescription(String.valueOf(updates.get("foodDescription")));
       if (updates.containsKey("foodPrice")) existingFood.setFoodPrice(Double.parseDouble(updates.get("foodPrice").toString()));
       if (updates.containsKey("categoryId")) {
            String categoryId = String.valueOf(updates.get("categoryId"));
            existingFood.setCategory(categoryService.getCategoryById(categoryId));
       }
        return FoodMapper.convertToFoodResponseDTO(foodRepository.save(existingFood));
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

    public Food getFoodById(String foodId) {
        return foodRepository.findById(foodId)
                .orElseThrow(() -> new NoSuchElementException("Food not found"));
    }
}
