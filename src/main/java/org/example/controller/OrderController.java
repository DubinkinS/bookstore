package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Book;
import org.example.domain.Delivery;
import org.example.domain.Order;
import org.example.dto.OrderRequestDTO;
import org.example.service.BookService;
import org.example.service.DeliveryService;
import org.example.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final BookService bookService;
    private final DeliveryService deliveryService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable int id) {
        Order order = orderService.findOrderById(id);
        return order != null
                ? ResponseEntity.ok(order)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderRequestDTO dto) {
        Book book = bookService.findBookById(dto.getBookId());
        if (book == null) {
            return ResponseEntity.status(404).body(null); // Если не найдена книга по полученному JSON
        }

        Delivery delivery = deliveryService.findDeliveryById(dto.getDeliveryId());
        if (delivery == null) {
            return ResponseEntity.status(404).body(null); // Если не найдена доставка по полученному JSON
        }

        Order order = Order.builder()
                .fio(dto.getBuyerFio())
                .book(book)
                .delivery(delivery)
                .build();

        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
