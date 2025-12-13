
package com.tastytown.backend.dto;

import jakarta.validation.constraints.*;


public record AuthRequestDTO(
        @NotBlank(message = "Email is required")
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        String userEmail,


        @NotBlank(message = "Password is required for authentication")
        @NotNull
        @NotEmpty
        String userPassword
) {
}