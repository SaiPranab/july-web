package com.tastytown.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String foodName;
    private double foodPrice;
    private int quantity;
}
