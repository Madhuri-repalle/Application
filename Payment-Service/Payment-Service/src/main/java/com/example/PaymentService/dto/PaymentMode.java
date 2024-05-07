package com.example.PaymentService.dto;

import lombok.Builder;
import lombok.Data;


public enum PaymentMode {
    CREDIT_CARD("Credit Card"),

    DEBIT_CARD("Debit Card"),

    NET_BANKING("Net Banking"),

    CASH_ON_DELIVERY("Cash on Delivery");
    private final String mode;
    PaymentMode(String mode) {

        this.mode = mode;

    }
    public String getMode() {

        return mode;

    }
   }
