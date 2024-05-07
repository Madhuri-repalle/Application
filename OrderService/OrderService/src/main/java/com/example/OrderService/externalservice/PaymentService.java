package com.example.OrderService.externalservice;

import com.example.OrderService.dto.PaymentRequest;
import com.example.OrderService.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="Payment-Service",url="http://localhost:8080/payment")

public interface PaymentService
{
@PostMapping("post")
    ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    @GetMapping("orderid/{orderId}")
    public PaymentResponse getPaymentDetails(@PathVariable long orderId);
}