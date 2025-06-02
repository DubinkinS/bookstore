package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Delivery;
import org.example.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping
    public List<Delivery> getAll() {
        return deliveryService.findAllDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getById(@PathVariable int id) {
        Delivery delivery = deliveryService.findDeliveryById(id);
        return delivery != null
                ? ResponseEntity.ok(delivery)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Delivery create(@RequestBody Delivery delivery) {
        return deliveryService.saveDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
