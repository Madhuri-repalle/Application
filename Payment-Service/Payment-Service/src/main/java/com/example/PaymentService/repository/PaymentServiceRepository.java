package com.example.PaymentService.repository;

import com.example.PaymentService.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentServiceRepository extends JpaRepository<TransactionDetails, Long> {
    Optional<TransactionDetails> findByOrderId(long orderId);
}
