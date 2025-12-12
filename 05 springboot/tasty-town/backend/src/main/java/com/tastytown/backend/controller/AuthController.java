package com.tastytown.backend.controller;

import com.tastytown.backend.constants.Role;
import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;
import com.tastytown.backend.dto.RegisterRequestDTO;
import com.tastytown.backend.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody  AuthRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterRequestDTO dto) {
        authService.register(dto, Role.ROLE_USER);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/register-admin")
    public ResponseEntity<Void> registerAdmin(@RequestBody RegisterRequestDTO dto) {
        authService.register(dto, Role.ROLE_ADMIN);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

