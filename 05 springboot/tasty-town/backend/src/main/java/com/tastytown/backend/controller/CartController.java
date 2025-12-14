package com.tastytown.backend.controller;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.service.ICartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public ResponseEntity<CartResponseDTO> addToCart(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO
            ) {
        return ResponseEntity.ok(cartService.addToCart(userId, cartItemRequestDTO));
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public ResponseEntity<CartResponseDTO> getCartByUserId(@RequestAttribute String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @SecurityRequirement(name = "bearerAuth")
    @PutMapping
    public ResponseEntity<CartResponseDTO> updateItemQuantity(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO ) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, cartItemRequestDTO));
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{foodId}/food")
    public ResponseEntity<CartResponseDTO> removeItem(
            @RequestAttribute String userId,
            @PathVariable String foodId ) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, foodId));
    }

    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping
    public ResponseEntity<Void> clearCart(@RequestAttribute String userId) {
        cartService.clearCartItems(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
