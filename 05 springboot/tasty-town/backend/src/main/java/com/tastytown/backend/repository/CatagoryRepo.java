package com.tastytown.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tastytown.backend.model.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, String>{
    
}
