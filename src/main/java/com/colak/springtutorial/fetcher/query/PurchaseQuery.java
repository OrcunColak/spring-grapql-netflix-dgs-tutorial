package com.colak.springtutorial.fetcher.query;


import com.colak.springtutorial.context.CustomContext;
import com.colak.springtutorial.jpa.Purchase;
import com.colak.springtutorial.repository.PurchaseRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.UUID;

@DgsComponent
@RequiredArgsConstructor
public class PurchaseQuery {
    private final PurchaseRepository purchaseRepository;

    @DgsData(parentType = "QueryResolver", field = "purchases")
    public Iterable<Purchase> findByCustomerId(@InputArgument("customerId") String customerId,
                                               DgsDataFetchingEnvironment dfe) {
        CustomContext customContext = DgsContext.getCustomContext(dfe);
        var purchases = customContext.getPurchases();
        if (CollectionUtils.isEmpty(purchases)) {
            return purchaseRepository.findByCustomerId(UUID.fromString(customerId));
        }
        var optional = customContext.getPurchases().stream()
                .filter(it -> it.getCustomer().getId().equals(UUID.fromString(customerId)))
                .toList();
        return optional.isEmpty()
                ? purchaseRepository.findByCustomerId(UUID.fromString(customerId))
                : optional;
    }
}
