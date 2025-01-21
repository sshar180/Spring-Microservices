package com.sharma.ecommerce.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {

        if(request == null)
        {
            return null;
        }
        return Customer.builder()
                .address(request.address())
                .email(request.email())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress());
    }
}
