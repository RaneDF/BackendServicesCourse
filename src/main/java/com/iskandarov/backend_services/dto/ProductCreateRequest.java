package com.iskandarov.backend_services.dto;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String name;
    private String description;
    private double price;
}
