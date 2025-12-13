package com.tastytown.backend.service.impl;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.repository.CartRepository;
import com.tastytown.backend.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;

    @Override
    public CartResponseDTO addToCart(String userId, CartItemRequestDTO cartItemRequestDTO) {
//        Check if user exists

//        Check if food exists

//        Check if cart exists, if not create a new cart

//        If Item already exists, increase the quantity

//        Otherwise add the item to cart

//        Save Cart

//        Convert Cart To CartResponseDTO & return
    }

    @Override
    public CartResponseDTO getCartByUserId(String userId) {
//        Check if user exists

//        extract the Cart for that user ( check if the cart exists for that user)

//        Convert Cart To CartResponseDTO & return
    }

    @Override
    public CartItemResponseDTO updateItemQuantity(String userId, CartItemRequestDTO cartItemRequestDTO)
//        Check if user exists

//        Check if cart exists

//        Find the item in the cart to update teh quantity (if the item not exists generate exception)

//        Update the auantity(increase or decrease the quantity)

//        When you re decreasing if quantity goes negative or zero, remove the item from cart

//        Save the Cart

//        Convert & return
    }

    @Override
    public CartResponseDTO removeItemFromCart(String userId, String foodId) {
//        check if user exists

//        Check if the cart exists for that user

//        check if food exists

//        remove item from cart (filter)

//        Save the cart

//        convert & return
    }

    @Override
    public void clearCartItems(String userId) {
//        check if user exists

//        Check if the cart exists for that user

//        Clear Cart Items
    }
}
