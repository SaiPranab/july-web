package com.tastytown.backend.service;

import com.tastytown.backend.constants.Role;
import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;
import com.tastytown.backend.dto.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(AuthRequestDTO dto);

    void register(RegisterRequestDTO dto, Role role);
}
