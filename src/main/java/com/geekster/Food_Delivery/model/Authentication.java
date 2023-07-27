package com.geekster.Food_Delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authenticationId;
    private String authenticationToken;
    private LocalDate localDate;
    @OneToOne
    @JoinColumn(nullable = false , name = "foreign_key")
    private Costumer costumer;

    public Authentication(Costumer costumer) {
        this.costumer = costumer;
        this.localDate=LocalDate.now();
        this.authenticationToken= UUID.randomUUID().toString();

    }
}
