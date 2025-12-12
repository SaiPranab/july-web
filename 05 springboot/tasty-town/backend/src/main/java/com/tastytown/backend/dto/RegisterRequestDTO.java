package com.tastytown.backend.dto;

public record RegisterRequestDTO(
        String username,
        String userEmail,
        String userPassword
) {
}
