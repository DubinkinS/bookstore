package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.CourierRepository;
import org.example.domain.Courier;
import org.example.domain.Delivery;
import org.example.domain.Shop;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final CourierRepository courierRepository;

    @Override
    public void deleteCourier(int id) {
        courierRepository.deleteById(id);
    }

    @Override
    public Courier findCourierById(int id) {
        return courierRepository.findCourierById(id);
    }

    @Override
    public List<Courier> findAllCouriers() {
        return courierRepository.findAll();
    }

    @Override
    public Courier saveCourier(Courier courier) {
        return courierRepository.save(courier);
    }
}



