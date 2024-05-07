package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private long id;
    private long amount;
    private long quantity;
    private PaymentMode paymentMode;
    private  LoginDto loginDto;

}

