package com.tastytown.backend.model;

import com.tastytown.backend.audit.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Category extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    private String categoryName;

}
