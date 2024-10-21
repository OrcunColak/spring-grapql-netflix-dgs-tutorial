package com.colak.springtutorial.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Shop {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String state;
    private String city;
    private String street;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private Set<Item> items;
}
