package com.tastytown.backend.controller;

import com.tastytown.backend.constants.Role;
import com.tastytown.backend.dto.AuthRequestDTO;
import com.tastytown.backend.dto.AuthResponseDTO;
import com.tastytown.backend.dto.RegisterRequestDTO;
import com.tastytown.backend.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid; // Assuming you've added validation to your DTOs

@Tag(name = "Authentication", description = "Endpoints for user registration and login")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService authService;

    @Operation(
            summary = "User Login",
            description = "Authenticates a user and returns a JWT token.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Authentication successful. Returns JWT token."

                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Invalid credentials."

                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request body (e.g., missing email/password)."
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @Operation(
            summary = "Register Standard User",
            description = "Creates a new user account with the default 'ROLE_USER' role.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User successfully registered."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Validation error or user already exists."
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody RegisterRequestDTO dto) {
        authService.register(dto, Role.ROLE_USER);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Register Admin User",
            description = "Creates a new user account with the 'ROLE_ADMIN' role. **Requires existing admin privileges for a real application.**",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Admin successfully registered."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Validation error or user already exists."
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden, if the current user lacks permission to create an admin."
                    )
            }
    )
    @PostMapping("/register-admin")
    public ResponseEntity<Void> registerAdmin(@Valid @RequestBody RegisterRequestDTO dto) {
        authService.register(dto, Role.ROLE_ADMIN);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}