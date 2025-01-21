package com.sharma.ecommerce.customer;

import com.sharma.ecommerce.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest customerRequest) {

        var customer = repository.findById(customerRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: No Customer Found with the provided ID:: %s", customerRequest.id())
                ));
        mergeCustomer(customer, customerRequest);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest customerRequest) {

        if (StringUtils.isNotBlank(customerRequest.firstname()))
            customer.setFirstname(customerRequest.firstname());
        if (StringUtils.isNotBlank(customerRequest.lastname()))
            customer.setLastname(customerRequest.lastname());
        if (StringUtils.isNotBlank(customerRequest.email()))
            customer.setEmail(customerRequest.email());
        if (customerRequest.address() != null)
            customer.setAddress(customerRequest.address());
    }

    public CustomerResponse getCustomerById(@Valid String customerId) {
       return repository.findById(customerId)
               .stream()
               .map(mapper::fromCustomer)
               .findFirst().orElseThrow(() -> new CustomerNotFoundException(
                     format("No Customer Found with the provided ID: %s ", customerId)
               ));
    }

    public List<CustomerResponse> getAllCustomer() {

        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {

            return repository.findById(customerId).isPresent();
    }

    public void deleteById(String customerId) {

        repository.deleteById(customerId);
    }
}



