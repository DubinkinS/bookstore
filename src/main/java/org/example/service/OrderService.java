package org.example.service;

import org.example.domain.Order;

import java.util.List;

public interface OrderService {
    void deleteOrder(int id);

    Order findOrderById(int id);

    List<Order> findAllOrders();

    Order saveOrder(Order order);
}
