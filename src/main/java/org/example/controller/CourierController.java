package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Courier;
import org.example.service.CourierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping
    public List<Courier> getAll() {
        return courierService.findAllCouriers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courier> getById(@PathVariable int id) {
        Courier courier = courierService.findCourierById(id);
        return courier != null
                ? ResponseEntity.ok(courier)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Courier create(@RequestBody Courier courier) {
        return courierService.saveCourier(courier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        courierService.deleteCourier(id);
        return ResponseEntity.noContent().build();
    }
}
