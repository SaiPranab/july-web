package com.tastytown.backend.repository;

import com.tastytown.backend.model.Cart;
import com.tastytown.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, String> {
    Optional<Cart> findByUser(UserEntity user);
}
