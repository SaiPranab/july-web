package com.tastytown.backend.repository;

import com.tastytown.backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, String> {

}
