package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.DeliveryRepository;
import org.example.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor

public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public void deleteDelivery(int id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public Delivery findDeliveryById(int id) {
        return deliveryRepository.findDeliveryById(id);
    }

    @Override
    public List<Delivery> findAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }
}


