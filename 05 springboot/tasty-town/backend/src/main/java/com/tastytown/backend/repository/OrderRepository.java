package com.tastytown.backend.repository;

import com.tastytown.backend.model.OrderEntity;
import com.tastytown.backend.model.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    List<OrderEntity> findAllByUser(UserEntity user, Sort sort);
}
