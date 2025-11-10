package com.example.methods_of_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
// @Getter
// @Setter
// @ToString
@Data
@Builder
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String productId;

  private String productName;

  private String productBrand;

  private Double productPrice;
}
