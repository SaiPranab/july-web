package com.example.security_demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String>{
  Optional<UserEntity> findByUserEmail(String email);
}