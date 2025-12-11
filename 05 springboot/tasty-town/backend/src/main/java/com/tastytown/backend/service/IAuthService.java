package com.tastytown.backend.service;

import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;

public interface IAuthService {
    AuthResponseDTO login(AuthRequestDTO dto);
}
