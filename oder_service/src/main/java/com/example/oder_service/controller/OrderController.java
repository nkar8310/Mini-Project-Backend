package com.example.oder_service.controller;

import com.example.oder_service.dto.OrderRequest;
import com.example.oder_service.model.Order;
import com.example.oder_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        // Extract user ID from the order request and pass it to the service
        String userId = orderRequest.getUserId();
        orderService.placeOrder(orderRequest, userId);
        return "Order Placed Successfully";
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        // Implement logic to retrieve all orders for a specific user ID from the service
        return orderService.getOrdersByUserId(userId);
    }
    @GetMapping
    public List<Order> getAllOrders() {
        // Implement logic to retrieve all orders from the service
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {
        // Implement logic to retrieve a specific order by ID from the service
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public String updateOrder(@PathVariable Long orderId, @RequestBody OrderRequest orderRequest) {
        // Implement logic to update a specific order by ID from the service
        orderService.updateOrder(orderId, orderRequest);
        return "Order Updated Successfully";
    }
}
