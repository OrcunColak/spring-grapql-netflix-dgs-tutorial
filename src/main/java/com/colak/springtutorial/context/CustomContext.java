package com.colak.springtutorial.context;

import com.colak.springtutorial.jpa.Customer;
import com.colak.springtutorial.jpa.Item;
import com.colak.springtutorial.jpa.Purchase;
import com.colak.springtutorial.jpa.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomContext {
    private final List<Shop> shops;
    private final List<Item> items;
    private final List<Customer> customers;
    private final List<Purchase> purchases;
}
