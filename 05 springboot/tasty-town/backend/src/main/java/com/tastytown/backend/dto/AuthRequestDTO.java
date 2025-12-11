package com.tastytown.backend.dto;

import lombok.Data;

public record AuthRequestDTO(String userEmail, String userPassword) {
}
