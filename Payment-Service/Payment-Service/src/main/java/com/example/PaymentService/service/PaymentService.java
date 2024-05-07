package com.example.PaymentService.service;

import com.example.PaymentService.dto.PaymentRequest;
import com.example.PaymentService.dto.PaymentResponse;

public interface PaymentService
{
    long doPayment(PaymentRequest paymentRequest);
    PaymentResponse getPaymentDetailsByOrderId(long orderId);

}
