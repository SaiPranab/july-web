package com.tastytown.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public record RegisterRequestDTO(

        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
        String username,

        @NotBlank(message = "Email is required")

        @Email(message = "Email should be a valid email address structure")
        String userEmail,

        @NotBlank(message = "Password is required")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$",
                message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character (!@#$%^&*)."
        )
        String userPassword
) {
}