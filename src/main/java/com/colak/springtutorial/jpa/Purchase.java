package com.colak.springtutorial.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Purchase {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Item item;

    private Instant date;
    private int quantity;
}
