package com.example.oder_service.service;

import com.example.oder_service.dto.OrderLineItemsDto;
import com.example.oder_service.dto.OrderRequest;
import com.example.oder_service.model.Order;
import com.example.oder_service.model.OrderLineItems;
import com.example.oder_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest, String userId) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setUserId(userId);

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }



    public List<Order> getAllOrders() {
        // Implement logic to retrieve all orders from the repository
        return orderRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        // Implement logic to retrieve a specific order by ID from the repository
        return orderRepository.findById(orderId).orElse(null);
    }
    public List<Order> getOrdersByUserId(String userId) {
        // Implement logic to retrieve all orders for a specific user ID from the repository
        return orderRepository.findByUserId(userId);
    }
    public void updateOrder(Long orderId, OrderRequest orderRequest) {
        // Implement logic to update a specific order by ID in the repository
        Order existingOrder = orderRepository.findById(orderId).orElse(null);

        if (existingOrder != null) {
            // Update existingOrder based on orderRequest
            // Save the updated order to the database
            orderRepository.save(existingOrder);
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
