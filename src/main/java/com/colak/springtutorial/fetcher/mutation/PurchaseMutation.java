package com.colak.springtutorial.fetcher.mutation;


import com.colak.springtutorial.fetcher.input.PurchaseInput;
import com.colak.springtutorial.jpa.Customer;
import com.colak.springtutorial.jpa.Item;
import com.colak.springtutorial.jpa.Purchase;
import com.colak.springtutorial.repository.CustomerRepository;
import com.colak.springtutorial.repository.ItemRepository;
import com.colak.springtutorial.repository.PurchaseRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class PurchaseMutation {
    private final PurchaseRepository purchaseRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @DgsData(parentType = "MutationResolver", field = "createPurchase")
    public Purchase createPurchase(@InputArgument("purchase") PurchaseInput purchaseInput) {
        Customer customer = customerRepository.findById(purchaseInput.getCustomerId())
                .orElseThrow(DgsEntityNotFoundException::new);

        Item item = itemRepository.findById(purchaseInput.getItemId())
                .orElseThrow(DgsEntityNotFoundException::new);

        Purchase purchase = Purchase.builder()
                .customer(customer)
                .item(item)
                .date(purchaseInput.getDate())
                .quantity(purchaseInput.getQuantity())
                .build();
        return purchaseRepository.save(purchase);
    }
}
