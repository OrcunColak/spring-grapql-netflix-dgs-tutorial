package com.colak.springtutorial.context;

import com.colak.springtutorial.jpa.Customer;
import com.colak.springtutorial.jpa.Item;
import com.colak.springtutorial.jpa.Purchase;
import com.colak.springtutorial.jpa.Shop;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomContextBuilder implements DgsCustomContextBuilder<CustomContext> {
    private List<Shop> shops;
    private List<Item> items;
    private List<Customer> customers;
    private List<Purchase> purchases;
    public CustomContextBuilder customContext(List<Shop> shops, List<Item> items,
                                              List<Customer> customers, List<Purchase> purchases) {
        this.shops = shops;
        this.items = items;
        this.customers = customers;
        this.purchases = purchases;
        return this;
    }

    @Override
    public CustomContext build() {
        return new CustomContext(shops, items, customers, purchases);
    }
}