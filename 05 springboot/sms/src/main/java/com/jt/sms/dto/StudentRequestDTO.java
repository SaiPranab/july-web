package com.jt.sms.dto;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private Integer roll;
    private String name;
    private String email;
    private Double fee;
    private String phoneNumber;
}
