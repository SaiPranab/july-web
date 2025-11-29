package com.jt.sms.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.jt.sms.annotation.StudentRoleValidation;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@JsonPropertyOrder({"email", "name"})
public class StudentDTO {
    @Positive
    @Min(value = 100)
    private Integer roll;

    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @Email
    private String email;

    @Digits(integer = 5, fraction = 2)
    @PositiveOrZero
    private Double fee;

    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "phone number should be in proper format")
    private String phoneNumber;

    @StudentRoleValidation
    @JsonAlias("studentRole")
    private String role;
}
