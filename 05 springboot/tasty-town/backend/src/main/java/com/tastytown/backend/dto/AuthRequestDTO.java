
package com.tastytown.backend.dto;

import jakarta.validation.constraints.*;


public record AuthRequestDTO(
        @NotBlank(message = "Email is required for authentication")
        @Email(message = "Email must be a valid email address format")
        String userEmail,


        @NotBlank(message = "Password is required for authentication")
        @NotNull
        @NotEmpty
        @Size(min = 16, message = "Password must be at least 8 characters long")
        String userPassword
) {
}