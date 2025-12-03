package com.tastytown.backend.repository;

import com.tastytown.backend.model.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {
    Page<Food> findAllByCategory_CategoryIdAndFoodNameContainingIgnoreCase
            (String categoryId, String search, Pageable pageable);

    Page<Food> findAllByCategory_CategoryId(String categoryId, Pageable pageable);

    Page<Food> findAllByFoodNameContainingIgnoreCase(String search, Pageable pageable);
}
