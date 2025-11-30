package com.tastytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tastytown.backend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    
}
