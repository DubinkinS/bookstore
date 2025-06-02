package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"order\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fio_bayer")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "book_cod")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "delivery_cod")
    @JsonIgnore
    private Delivery delivery;
}