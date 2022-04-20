package com.example.capstone.services;

import com.example.capstone.entity.Order;
import com.example.capstone.models.CartInfo;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Order saveOrder(CartInfo order);

    void saveOrder(Order order);

    Order getOrderById(String id);

    Optional<Order> getOrderByName(String name);

    void deleteOrderById(String id);
}