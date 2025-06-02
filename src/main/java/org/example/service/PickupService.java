package org.example.service;

import org.example.domain.Pickup;

public interface PickupService {
    void deletePickup(int id);

    Pickup findPickupById(int id);
}
