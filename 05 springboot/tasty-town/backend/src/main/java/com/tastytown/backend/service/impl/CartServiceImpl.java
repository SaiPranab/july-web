package com.tastytown.backend.service.impl;

import com.tastytown.backend.dto.CartItemRequestDTO;
import com.tastytown.backend.dto.CartItemResponseDTO;
import com.tastytown.backend.dto.CartResponseDTO;
import com.tastytown.backend.mapper.CartMapper;
import com.tastytown.backend.model.Cart;
import com.tastytown.backend.model.CartItem;
import com.tastytown.backend.model.Food;
import com.tastytown.backend.model.UserEntity;
import com.tastytown.backend.repository.CartRepository;
import com.tastytown.backend.repository.FoodRepository;
import com.tastytown.backend.repository.UserRepository;
import com.tastytown.backend.service.ICartService;
import com.tastytown.backend.service.IFoodService;
import com.tastytown.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;
    private final IFoodService foodService;
    private final IUserService userService;

    @Override
    public CartResponseDTO addToCart(String userId, CartItemRequestDTO cartItemRequestDTO) {
//        Check if user exists
        UserEntity user = userService.getUserById(userId);

//        Check if food exists
        Food food = foodService.getFoodById(cartItemRequestDTO.foodId());

//        Check if cart exists, if not create a new cart
        Cart cart = getCartOfAnUser(user);

//        Check if item already exists in the cart
        Optional<CartItem> existingItemOpt = cart.getItems().stream()
                .filter((cartItem -> cartItem.getFood().getFoodId().equals(cartItemRequestDTO.foodId())))
                .findFirst();

//        If item already exists increase its quantity
        if(existingItemOpt.isPresent()) {
            CartItem existingCartItem = existingItemOpt.get();
            existingCartItem.setQuantity(existingCartItem.getQuantity() + cartItemRequestDTO.quantity());
        } else {
//            Otherwise create a new Cart Item
            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setFood(food);
            newCartItem.setQuantity(cartItemRequestDTO.quantity());
            cart.getItems().add(newCartItem);
        }

//        Save Cart
        Cart savedCart = cartRepository.save(cart);

//        Convert Cart To CartResponseDTO & return
        return CartMapper.convertToDTO(savedCart);
    }

    @Override
    public CartResponseDTO getCartByUserId(String userId) {
//        Check if user exists
        UserEntity user = userService.getUserById(userId);

//        extract the Cart for that user ( check if the cart exists for that user)
        Cart existingCartOfAnUser = getCartOfAnUser(user);

//        Convert Cart To CartResponseDTO & return
        return CartMapper.convertToDTO(existingCartOfAnUser);
    }

    @Override
    public CartResponseDTO updateItemQuantity(String userId, CartItemRequestDTO cartItemRequestDTO) {
//        Check if user exists
        UserEntity user = userService.getUserById(userId);

//        Check if cart exists for that user
        Cart cartOfAnUser = getCartOfAnUser(user);

//        Find the item in the cart to update teh quantity (if the item not exists generate exception)
        CartItem existingCartItem = cartOfAnUser.getItems().stream()
                .filter(cartItem -> cartItem.getFood().getFoodId().equals(cartItemRequestDTO.foodId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item Not Found"));

//      Update the auantity
        if(cartItemRequestDTO.quantity() <= 0) {
//            quantity is negative or zero remove the item from cart
            cartOfAnUser.getItems().remove(existingCartItem);
        } else {
//            otherwise update quantity of item
            existingCartItem.setQuantity(cartItemRequestDTO.quantity());
        }

//        Save the Cart
        Cart savedCart = cartRepository.save(cartOfAnUser);

//        Convert & return
        return CartMapper.convertToDTO(savedCart);
    }

    @Override
    public CartResponseDTO removeItemFromCart(String userId, String foodId) {
//        check if user exists
        UserEntity user = userService.getUserById(userId);

//        Check if the cart exists for that user
        Cart cartOfAnUser = getCartOfAnUser(user);

//        check if food exists
        Food food = foodService.getFoodById(foodId);

//        remove item from cart (filter)
        List<CartItem> cartItemsOfAnUser = cartOfAnUser.getItems();
        CartItem toBeRemovedCartItem = cartItemsOfAnUser.stream()
                .filter(cartItem -> cartItem.getFood().getFoodId().equals(foodId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Food not found"));

        cartItemsOfAnUser.remove(toBeRemovedCartItem);

//        Save the cart
        Cart updatedCart = cartRepository.save(cartOfAnUser);

//        convert & return
        return CartMapper.convertToDTO(updatedCart);
    }

    @Override
    public void clearCartItems(String userId) {
//        check if user exists
        UserEntity user = userService.getUserById(userId);

//        Check if the cart exists for that user
        Cart cartOfAnUser = getCartOfAnUser(user);

//        Clear Cart Items
        cartOfAnUser.getItems().clear();

//      update cart
        cartRepository.save(cartOfAnUser);
    }

    public Cart getCartOfAnUser(UserEntity user) {
        return cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });
    }
}
