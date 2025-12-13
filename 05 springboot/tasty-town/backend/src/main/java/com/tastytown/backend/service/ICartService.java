package com.tastytown.backend.service;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;

public interface ICartService {
    CartResponseDTO addToCart(String userId, CartItemRequestDTO cartItemRequestDTO);

    CartResponseDTO getCartByUserId(String userId);

    CartItemResponseDTO updateItemQuantity(String userId, CartItemRequestDTO cartItemRequestDTO);

    CartResponseDTO removeItemFromCart(String userId, String foodId);

    void clearCartItems(String userId);
}
