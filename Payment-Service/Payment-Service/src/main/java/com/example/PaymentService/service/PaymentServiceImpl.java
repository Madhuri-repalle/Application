package com.example.PaymentService.service;

import com.example.PaymentService.dto.PaymentMode;
import com.example.PaymentService.dto.PaymentRequest;
import com.example.PaymentService.dto.PaymentResponse;
import com.example.PaymentService.entity.TransactionDetails;
import com.example.PaymentService.exception.PaymentCustomException;
import com.example.PaymentService.repository.PaymentServiceRepository;
import jakarta.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentServiceRepository paymentServiceRepository;
    @Override
    public long doPayment(PaymentRequest paymentRequest) {
        log.info("PaymentServiceImpl | doPayment is called");
        log.info("PaymentServiceImpl | record payment details : {}", paymentRequest);
        UUID custom= UUID.randomUUID();
        TransactionDetails transactionDetails=TransactionDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .refferenceNumber(custom.toString())
                .paymentStatus("SUCCESS")
                .paymentMode(paymentRequest.getPaymentMode())
                .amount(paymentRequest.getAmount())
                .build();
        transactionDetails=paymentServiceRepository.save(transactionDetails);
        log.info("trasaction is done id : {}",transactionDetails.getPaymentId());
        return transactionDetails.getPaymentId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {
log.info("getPaymentDetailsByOrderId is called");
TransactionDetails transactionDetails=paymentServiceRepository.findByOrderId(orderId)
        .orElseThrow(() -> new PaymentCustomException("given transaction id is not found",
                "Transaction_not_found"));
PaymentResponse paymentResponse=PaymentResponse.builder()
        .paymentId(transactionDetails.getPaymentId())
        .paymentStatus(transactionDetails.getPaymentStatus())
        .orderId(transactionDetails.getOrderId())
        .amount(transactionDetails.getAmount())
        .paymentDate(transactionDetails.getPaymentDate())
        .paymentMode(transactionDetails.getPaymentMode())
        .build();
log.info("paymentResponse : {}",paymentResponse.toString());
        return paymentResponse;
    }
}
