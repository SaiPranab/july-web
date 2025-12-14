package com.tastytown.backend.service;

import com.tastytown.backend.model.UserEntity;

import java.util.Optional;

public interface IUserService {
    UserEntity getUserById(String userId);

    Optional<UserEntity> getUserByEmail(String email);
}
