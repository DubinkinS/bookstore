package org.example.service;

import org.example.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    void deleteDelivery(int id);

    Delivery findDeliveryById(int id);

    List<Delivery> findAllDeliveries();

    Delivery saveDelivery(Delivery delivery);
}
