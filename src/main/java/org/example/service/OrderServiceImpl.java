package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.OrderRepository;
import org.example.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final BookRepository bookRepository;
    private final BookService bookService;
    private final DeliveryService deliveryService;

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
