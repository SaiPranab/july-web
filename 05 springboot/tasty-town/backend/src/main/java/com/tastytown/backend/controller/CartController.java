package com.tastytown.backend.controller;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.service.ICartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CartController-API", description = "Endpoints for managing the user's shopping cart. Requires 'bearerAuth'.")
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final ICartService cartService;

    @Operation(summary = "Add a food item to the cart or increment its quantity.")
    @ApiResponse(responseCode = "200", description = "Item added/quantity updated successfully."
           )
    @ApiResponse(responseCode = "404", description = "Food item not found.")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public ResponseEntity<CartResponseDTO> addToCart(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO
    ) {
        return ResponseEntity.ok(cartService.addToCart(userId, cartItemRequestDTO));
    }

    @Operation(summary = "Retrieve the complete shopping cart for the authenticated user.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved cart contents.",
            content = @Content(schema = @Schema(implementation = CartResponseDTO.class)))
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public ResponseEntity<CartResponseDTO> getCartByUserId(@RequestAttribute String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @Operation(summary = "Update the quantity of a specific item already in the cart.")
    @ApiResponse(responseCode = "200", description = "Quantity updated successfully.",
            content = @Content(schema = @Schema(implementation = CartResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "Cart or item not found.")
    @SecurityRequirement(name = "bearerAuth")
    @PutMapping
    public ResponseEntity<CartResponseDTO> updateItemQuantity(
            @RequestAttribute String userId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO ) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, cartItemRequestDTO));
    }

    @Operation(summary = "Remove a specific food item entirely from the cart.")
    @ApiResponse(responseCode = "200", description = "Item removed successfully.",
            content = @Content(schema = @Schema(implementation = CartResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "Item not found in the cart.")
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{foodId}/food")
    public ResponseEntity<CartResponseDTO> removeItem(
            @RequestAttribute String userId,
            @PathVariable String foodId ) {
        return ResponseEntity.ok(cartService.removeItemFromCart(userId, foodId));
    }

    @Operation(summary = "Clear all items from the user's cart.")
    @ApiResponse(responseCode = "204", description = "Cart successfully cleared (No Content).")
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping
    public ResponseEntity<Void> clearCart(@RequestAttribute String userId) {
        cartService.clearCartItems(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}