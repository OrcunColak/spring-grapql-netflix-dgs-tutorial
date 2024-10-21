package com.colak.springtutorial.fetcher.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseInput {
    private UUID customerId;
    private UUID itemId;
    private Instant date;
    private int quantity;
}