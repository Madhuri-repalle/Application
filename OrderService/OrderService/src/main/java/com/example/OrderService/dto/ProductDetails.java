package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@Builder
@NoArgsConstructor

public class ProductDetails
{
    private long id;
    private String name;
    private String description;
    private long price;
}
