package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private long paymentId;
    private String paymentStatus;
    private PaymentMode paymentMode;
    private Instant paymentDate;
    private long orderId;
    private long amount;

}

