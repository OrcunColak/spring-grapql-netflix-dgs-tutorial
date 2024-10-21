package com.colak.springtutorial.fetcher.mutation;


import com.colak.springtutorial.fetcher.input.CustomerInput;
import com.colak.springtutorial.jpa.Customer;
import com.colak.springtutorial.repository.CustomerRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class CustomerMutation {
    private final CustomerRepository customerRepository;

    @DgsData(parentType = "MutationResolver", field = "createCustomer")
    public Customer createCustomer(@InputArgument("customer") CustomerInput customerInput) {
        Customer customer = Customer.builder()
                .firstName(customerInput.getFirstName())
                .lastName(customerInput.getLastName())
                .email(customerInput.getEmail())
                .phone(customerInput.getPhone())
                .state(customerInput.getState())
                .city(customerInput.getCity())
                .street(customerInput.getStreet())
                .amount(customerInput.getAmount())
                .build();

        return customerRepository.save(customer);
    }
}
