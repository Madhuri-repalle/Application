package com.example.PaymentService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentCustomException extends RuntimeException{
    private   String errorCode;
    public PaymentCustomException(String message,String errorCOde)
    {
        super(message);
        this.errorCode=errorCode;
    }
}
