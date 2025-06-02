package org.example.service;

import org.example.domain.Courier;

import java.util.List;

public interface CourierService {
    void deleteCourier(int id);

    Courier findCourierById(int id);

    List<Courier> findAllCouriers();

    Courier saveCourier(Courier courier);
}
