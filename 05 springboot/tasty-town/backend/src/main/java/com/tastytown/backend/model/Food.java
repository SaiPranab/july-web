package com.tastytown.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String foodId;

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private String foodImage;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
