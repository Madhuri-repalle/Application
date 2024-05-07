package com.example.PaymentService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PaymentResponse {
    private long paymentId;
    private String paymentStatus;
    private PaymentMode paymentMode;
    private long amount;
    private Instant paymentDate;
    private long orderId;
}
