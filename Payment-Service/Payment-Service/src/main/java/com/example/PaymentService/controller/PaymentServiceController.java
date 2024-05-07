package com.example.PaymentService.controller;

import com.example.PaymentService.dto.PaymentRequest;
import com.example.PaymentService.dto.PaymentResponse;
import com.example.PaymentService.service.PaymentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentServiceController {
    @Autowired
    private  PaymentServiceImpl paymentServiceImpl;

    @PostMapping("/post")
    public ResponseEntity<Long> payment(@RequestBody PaymentRequest paymentRequest) {
        log.info("PaymentServiceController | payment is called");
        return new ResponseEntity<>(paymentServiceImpl.doPayment(paymentRequest),
                HttpStatus.OK);

    }

    @GetMapping("orderid/{orderId}")
    public PaymentResponse getPaymentDetails(@PathVariable long orderId) {
        log.info("PaymentServiceImpl | getPaymentDetails is called");
        return paymentServiceImpl.getPaymentDetailsByOrderId(orderId);
    }
}