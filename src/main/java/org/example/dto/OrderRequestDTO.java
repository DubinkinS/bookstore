package org.example.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private String buyerFio;
    private int bookId;
    private int deliveryId;
}
