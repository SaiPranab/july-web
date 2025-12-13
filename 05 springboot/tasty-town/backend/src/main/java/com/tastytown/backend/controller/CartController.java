package com.tastytown.backend.controller;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDTO> addToCart(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO
            ) {
        return ResponseEntity.ok(cartService.addToCart(userId, cartItemRequestDTO));
    }

    @GetMapping
    public ResponseEntity<CartResponseDTO> getCartByUserId(@RequestAttribute String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @PutMapping
    public ResponseEntity<CartItemResponseDTO> updateItemQuantity(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO ) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, cartItemRequestDTO));
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<CartResponseDTO> removeItem(
            @RequestAttribute String userId,
            @PathVariable String foodId ) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, foodId));
    }

//    Clear All the Cart Items
    @DeleteMapping
    public ResponseEntity<Void> clearCart(@RequestAttribute String userId) {
        cartService.clearCartItems(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
