package com.example.methods_of_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.methods_of_jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
  
}
