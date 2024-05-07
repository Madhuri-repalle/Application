package com.example.OrderService.exception;

import com.example.OrderService.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class HandlingOrderException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(OrderCustomException.class)
    public ResponseEntity<com.example.OrderService.dto.ErrorResponse> handleException(OrderCustomException exception)
    {
        return new ResponseEntity<>(new ErrorResponse().builder()
                .errorCode(exception.getErrorCode())
                .errorMessage(exception.getMessage())
                .build(),HttpStatus.valueOf(exception.getStatus()));

    }
}

