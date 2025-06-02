package org.example.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_cod")
    @JsonIgnore
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @Builder.Default
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();
}