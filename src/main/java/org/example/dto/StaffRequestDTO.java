package org.example.dto;

import lombok.Data;

@Data
public class StaffRequestDTO {
    private String staffFio;
    private String birthday;
    private String address;
    private String phoneNumber;
    private int postId;
    private int shopId;
}
