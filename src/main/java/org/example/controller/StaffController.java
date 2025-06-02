package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.*;
import org.example.dto.StaffRequestDTO;
import org.example.service.PostService;
import org.example.service.ShopService;
import org.example.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;
    private final PostService postService;
    private final ShopService shopService;

    @GetMapping
    public List<Staff> getAll() {
        return staffService.findAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getById(@PathVariable int id) {
        Staff staff = staffService.findStaffById(id);
        return staff != null
                ? ResponseEntity.ok(staff)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Staff> create(@RequestBody StaffRequestDTO dto) {
        Post post = postService.findPostById(dto.getPostId());
        if (post == null) {
            return ResponseEntity.status(404).body(null); // Если не найдена должность по полученному JSON
        }

        Shop shop = shopService.findShopById(dto.getShopId());
        if (shop == null) {
            return ResponseEntity.status(404).body(null); // Если не найден магазин по полученному JSON
        }

        Staff staff = Staff.builder()
                .fio(dto.getStaffFio())
                .birthdate(dto.getBirthday())
                .address(dto.getAddress())
                .mobile(dto.getPhoneNumber())
                .post(post)
                .shop(shop)
                .build();

        return ResponseEntity.ok(staffService.saveStaff(staff));
    }

    @PutMapping("/{staffId}/shop/{shopId}")
    public ResponseEntity<Staff> changeStaffShop(
            @PathVariable int staffId,
            @PathVariable int shopId) {

        Staff staff = staffService.findStaffById(staffId);
        if (staff == null) {
            return ResponseEntity.status(404).body(null);
        }

        Shop shop = shopService.findShopById(shopId);
        if (shop == null) {
            return ResponseEntity.status(404).body(null);
        }

        staff.setShop(shop);
        return ResponseEntity.ok(staffService.saveStaff(staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
