package com.example.OrderService.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderCustomException extends RuntimeException{
    private String errorCode;
    private int status;
    public OrderCustomException(String message,String errorCode,int status)
    {
        super(message);
        this.errorCode=errorCode;
        this.status=status;
    }
}