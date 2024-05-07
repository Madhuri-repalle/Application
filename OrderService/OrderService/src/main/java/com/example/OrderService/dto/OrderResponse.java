
package com.example.OrderService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private long orderId;
    private String orderStatus;
    private PaymentDetails paymentDetails;
    private ProductDetails productDetails;
    private long amount;
    private Instant orderDate;
    private long quantity;




}

