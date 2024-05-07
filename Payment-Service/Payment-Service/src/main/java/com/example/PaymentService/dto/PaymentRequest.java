package com.example.PaymentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder@Data
public class PaymentRequest {
    private long orderId;
    private long amount;
    private String refferenceNumber;
    private PaymentMode paymentMode;

}
