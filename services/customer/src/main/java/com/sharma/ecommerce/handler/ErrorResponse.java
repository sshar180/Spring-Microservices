package com.sharma.ecommerce.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
//
//public record ErrorResponse(Map<String, String> errors) {
//}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Map<String, String> errors;
}