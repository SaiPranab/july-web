package com.tastytown.backend.mapper;

import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.model.Cart;

import java.util.List;

public class CartMapper {
    private CartMapper(){}

    public static CartResponseDTO convertToDTO(Cart cart) {
        List<CartItemResponseDTO> items = cart.getItems().stream()
                .map(cartItem -> new CartItemResponseDTO(
                        cartItem.getFood().getFoodId(),
                        cartItem.getQuantity(),
                        cartItem.getFood().getFoodName(),
                        cartItem.getFood().getCategory().getCategoryName(),
                        cartItem.getFood().getFoodPrice()
                )).toList();

        return new CartResponseDTO(items);
    }
}
