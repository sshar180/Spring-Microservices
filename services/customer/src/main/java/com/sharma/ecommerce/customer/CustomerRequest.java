package com.sharma.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest (

     @NotNull(message = "Customer firstname is required")
     String firstname,
     @NotNull(message = "Customer lastname is required")
     String lastname,
     @NotNull(message = "Custom email is required")
     @Email(message = "Customer email is not a valid email address")
     String email,
     Address address,
     String id
)
{

}
