package com.sharma.ecommerce.customer;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest customerRequest)
    {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest customerRequest)
    {
        customerService.updateCustomer(customerRequest);
        return ResponseEntity.accepted().build();

    }

    @GetMapping("get-customer")
    public ResponseEntity<CustomerResponse> getCustomer(@RequestParam @Valid String customerId)
    {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers()
    {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/exists/{customer_id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("customer_id") String customerId)
    {
        return ResponseEntity.ok(customerService.existsById(customerId));
    }

    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity<Void> deleteById(@PathVariable("customer_id") String customerId)
    {
        customerService.deleteById(customerId);
        return ResponseEntity.accepted().build();
    }


}
