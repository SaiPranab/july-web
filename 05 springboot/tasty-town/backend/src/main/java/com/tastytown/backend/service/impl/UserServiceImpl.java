package com.tastytown.backend.service.impl;

import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.UserRepository;
import com.tastytown.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;


    @Override
    public UserEntity getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }
}
