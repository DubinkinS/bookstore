package org.example.dto;

import lombok.Data;

@Data
public class BookRequestDTO {
    private String name;
    private int authorId; // вместо вложенного объекта Author
}
