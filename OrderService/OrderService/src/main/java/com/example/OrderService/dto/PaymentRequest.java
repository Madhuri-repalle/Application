package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private long orderId;
    private String refferenceNumber;
    private PaymentMode paymentMode;
    private long amount;
}
