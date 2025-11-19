package com.example.methods_of_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.methods_of_jpa.model.Order;

public interface OrderRepository extends JpaRepository<Order, String>{
  
}
