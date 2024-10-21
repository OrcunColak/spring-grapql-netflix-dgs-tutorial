package com.colak.springtutorial.fetcher.mutation;


import com.colak.springtutorial.fetcher.input.ItemInput;
import com.colak.springtutorial.jpa.Item;
import com.colak.springtutorial.jpa.Shop;
import com.colak.springtutorial.repository.ItemRepository;
import com.colak.springtutorial.repository.ShopRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ItemMutation {
    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;

    @DgsData(parentType = "MutationResolver", field = "createItem")
    public Item createItem(@InputArgument("item") ItemInput itemInput) {
        Shop shop = shopRepository.findById(itemInput.getShopId())
                .orElseThrow(DgsEntityNotFoundException::new);

        Item item = Item.builder()
                .name(itemInput.getName())
                .inventory(itemInput.getInventory())
                .price(itemInput.getPrice())
                .shop(shop)
                .build();
        return itemRepository.save(item);
    }
}
