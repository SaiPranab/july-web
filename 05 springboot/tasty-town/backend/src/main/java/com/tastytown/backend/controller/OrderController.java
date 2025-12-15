package com.tastytown.backend.controller;

import com.tastytown.backend.constants.OrderStatus;
import com.tastytown.backend.dto.BillingInfoDTO;
import com.tastytown.backend.dto.OrderDTO;
import com.tastytown.backend.service.IOrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {
    private final IOrderService orderService;

    //    Place order
    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestAttribute String userId, @RequestBody BillingInfoDTO billingInfo) {
        return new ResponseEntity<>(orderService.createOrder(userId, billingInfo), HttpStatus.CREATED);
    }

    //    Get Order of an user
    @GetMapping("/user")
    public ResponseEntity<OrderDTO> getOrdersOfAnUser(@RequestAttribute String userId) {
        return ResponseEntity.ok(orderService.getOrdersOfAnUser(userId));
    }

    //    Get All orders of all users
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(@RequestAttribute String userId) {
        return ResponseEntity.ok(orderService.getAllOrders(userId));
    }

    //    update order status
    @PutMapping("/{orderId}/order/status")
    public ResponseEntity<OrderDTO> updateOrderStatus(@PathVariable String orderId,
                                                      @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }
}
