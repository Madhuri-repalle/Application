package com.example.PaymentService.entity;

import com.example.PaymentService.dto.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long paymentId;
    private long orderId;
    private String refferenceNumber;
    private Instant paymentDate;
    private String paymentStatus;
    private long amount;
    private PaymentMode paymentMode;
}
