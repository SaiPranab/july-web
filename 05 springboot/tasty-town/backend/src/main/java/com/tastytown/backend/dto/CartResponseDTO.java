package com.tastytown.backend.dto;

import java.util.ArrayList;
import java.util.List;

public record CartResponseDTO(
        List<CartItemResponseDTO> items
) {
}
