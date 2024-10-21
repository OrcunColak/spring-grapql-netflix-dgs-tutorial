package com.colak.springtutorial.fetcher.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemInput {
    private String name;
    private int inventory;
    private double price;
    private UUID shopId;
}