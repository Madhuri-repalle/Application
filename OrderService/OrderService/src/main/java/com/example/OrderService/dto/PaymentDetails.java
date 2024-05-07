package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@Builder

@NoArgsConstructor

public class
PaymentDetails
{
    private long paymentId;
    private PaymentMode paymentMode;
    private String paymentStatus;
    private Instant paymentDate;
}