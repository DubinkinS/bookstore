package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class PickupServiceImpl implements PickupService {

    private final PickupRepository pickupRepository;
    private final ShopRepository shopRepository;
    private final ShopService shopService;

    @Override
    public void deletePickup(int id) {
        pickupRepository.deleteById(id);
    }

    @Override
    public Pickup findPickupById(int id) {
        return pickupRepository.findPickupById(id);
    }
}