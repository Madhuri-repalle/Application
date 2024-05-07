package com.example.OrderService.service;

import com.example.OrderService.dto.LoginDto;
import com.example.OrderService.dto.OrderRequest;
import com.example.OrderService.dto.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest, LoginDto loginDto);
    OrderResponse getOrderDetails(long orderId);
}
