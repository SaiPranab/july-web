package com.tastytown.backend.dto;

public record BillingInfoDTO(
        String fullName,
        String email,
        String phoneNumber,
        String address,
        String city,
        String state,
        String zip
) {
}
