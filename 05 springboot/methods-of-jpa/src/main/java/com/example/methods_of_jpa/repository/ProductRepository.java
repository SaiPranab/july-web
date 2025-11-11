package com.example.methods_of_jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.methods_of_jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findByProductName(String name);

  List<Product> findAllByProductPriceBetween(double startPrice, double endPrice);

  List<Product> findAllByProductPriceGreaterThan(double price);

  List<Product> findAllByProductPriceGreaterThanEqual(double price);

  List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

  Optional<Product> findByProductPriceAndProductBrand(double price, String brand);

  List<Product> findAllByProductNameIsNotNull();
}
