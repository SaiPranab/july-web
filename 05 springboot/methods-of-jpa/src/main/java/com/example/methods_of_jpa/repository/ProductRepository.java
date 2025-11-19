package com.example.methods_of_jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.methods_of_jpa.model.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findByProductName(String name);

  List<Product> findAllByProductPriceBetween(double startPrice, double endPrice);

  List<Product> findAllByProductPriceGreaterThan(double price);

  List<Product> findAllByProductPriceGreaterThanEqual(double price);

  List<Product> findAllByProductPriceGreaterThanEqual(double price, Sort sort);

  Optional<Product> findByProductPriceAndProductBrand(double price, String brand);

  List<Product> findAllByProductNameIsNotNull();


  // ============================ JPQL =========================
  @Query(value = "SELECT p FROM Product p WHERE p.productPrice=?1 AND p.productBrand=?2") // positional parameter
  Optional<Product> getProduct1(double price, String brand); 

  @Query(value = "SELECT p FROM Product p WHERE p.productPrice=:price AND p.productBrand=:brand") // named parameter
  Optional<Product> getProduct2(@Param("price") double price1, @Param("brand") String brand1); 


  // ============================ NATIVE SQL ==============================
  @Query(value = "SELECT * FROM product WHERE product_price=:price AND product_brand=:brand", nativeQuery = true)
  Optional<Product> getProduct3(double price, String brand); 

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "UPDATE product SET product_price=:price WHERE product_brand=:brand")
  long updateProduct(double price, String brand);
}
