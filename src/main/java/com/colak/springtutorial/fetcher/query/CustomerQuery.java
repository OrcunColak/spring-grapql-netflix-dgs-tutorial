package com.colak.springtutorial.fetcher.query;

import com.colak.springtutorial.context.CustomContext;
import com.colak.springtutorial.context.CustomContextBuilder;
import com.colak.springtutorial.jpa.Customer;
import com.colak.springtutorial.repository.CustomerRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@DgsComponent
@RequiredArgsConstructor
public class CustomerQuery {
    private final CustomerRepository customerRepository;
    private final CustomContextBuilder contextBuilder;

    @DgsData(parentType = "QueryResolver", field = "customers")
    public Iterable<Customer> findAll(DgsDataFetchingEnvironment dfe) {
        var customers = (List<Customer>) customerRepository.findAll();
        contextBuilder.customContext(null, null, customers, null).build();
        return customers;
    }

    @DgsData(parentType = "QueryResolver", field = "customer")
    public Customer findById(@InputArgument("id") String id, DgsDataFetchingEnvironment dfe) {
        CustomContext customContext = DgsContext.getCustomContext(dfe);

        var customers = customContext.getCustomers();
        if (CollectionUtils.isEmpty(customers)) {
            return customerRepository.findById(UUID.fromString(id))
                    .orElseThrow(DgsEntityNotFoundException::new);
        }
        var customer = customers.stream().filter(it -> it.getId().equals(UUID.fromString(id)))
                .findFirst();
        return customer.orElseGet(() -> customerRepository.findById(UUID.fromString(id))
                .orElseThrow(DgsEntityNotFoundException::new));
    }
}