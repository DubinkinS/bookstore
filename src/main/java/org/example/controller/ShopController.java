package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Shop;
import org.example.dto.ShopRequestDTO;
import org.example.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping
    public List<Shop> getAll() {
        return shopService.findAllShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getById(@PathVariable int id) {
        Shop shop = shopService.findShopById(id);
        return shop != null
                ? ResponseEntity.ok(shop)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Shop> create(@RequestBody ShopRequestDTO dto) {
        Shop shop = Shop.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .staffCount(dto.getStaffCount())
                .build();

        return ResponseEntity.ok(shopService.saveShop(shop));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }
}
