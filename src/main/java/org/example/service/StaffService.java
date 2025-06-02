package org.example.service;

import org.example.domain.Order;
import org.example.domain.Staff;

import java.util.List;

public interface StaffService {
    void deleteStaff(int id);

    Staff findStaffById(int id);

    List<Staff> findAllStaff();

    Staff saveStaff(Staff staff);
}
