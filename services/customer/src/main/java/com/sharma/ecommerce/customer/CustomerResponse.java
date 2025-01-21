package com.sharma.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

public record CustomerResponse (
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
)
{

}
