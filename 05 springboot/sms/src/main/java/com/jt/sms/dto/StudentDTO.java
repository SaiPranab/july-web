package com.jt.sms.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class StudentDTO {
    @Positive
    private Integer roll;
    private String name;
    private String email;
    private Double fee;
    private String phoneNumber;
}
