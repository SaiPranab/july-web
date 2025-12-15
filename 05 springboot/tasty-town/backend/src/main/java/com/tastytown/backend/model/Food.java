package com.tastytown.backend.model;

import com.tastytown.backend.audit.TastyTownAuditableEntity;
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
public class Food extends TastyTownAuditableEntity {
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
