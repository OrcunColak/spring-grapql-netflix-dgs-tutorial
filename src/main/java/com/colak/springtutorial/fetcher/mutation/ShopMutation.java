package com.colak.springtutorial.fetcher.mutation;

import com.colak.springtutorial.fetcher.input.ShopInput;
import com.colak.springtutorial.jpa.Shop;
import com.colak.springtutorial.repository.ShopRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ShopMutation {
    private final ShopRepository shopRepository;

    @DgsData(parentType = "MutationResolver", field = "createShop")
    public Shop createCustomer(@InputArgument("shop") ShopInput shopInput) {
        Shop shop = Shop.builder()
                .name(shopInput.getName())
                .email(shopInput.getEmail())
                .phone(shopInput.getPhone())
                .state(shopInput.getState())
                .city(shopInput.getCity())
                .street(shopInput.getStreet())
                .build();
        return shopRepository.save(shop);
    }
}
