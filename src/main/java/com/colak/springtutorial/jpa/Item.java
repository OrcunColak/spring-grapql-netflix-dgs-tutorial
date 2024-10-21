package com.colak.springtutorial.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int inventory;
    private double price;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Purchase> customers;

    @ManyToOne
    private Shop shop;
}
