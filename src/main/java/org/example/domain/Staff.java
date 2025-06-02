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
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    private String birthdate;

    private String address;

    private String mobile;

    @ManyToOne
    @JoinColumn(name = "post_cod")
    @JsonIgnore
    private Post post;

    @ManyToOne
    @JoinColumn(name = "shop_cod")
    private Shop shop;
}


