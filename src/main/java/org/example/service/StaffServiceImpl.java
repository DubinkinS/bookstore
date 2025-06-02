package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.*;
import org.example.domain.PostRepository;
import org.example.domain.ShopRepository;
import org.example.domain.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor

public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final PostService postService;
    private final ShopService shopService;

    @Override
    public void deleteStaff(int id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff findStaffById(int id) {
        return staffRepository.findStaffById(id);
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }
}
