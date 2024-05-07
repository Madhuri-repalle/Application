package com.example.OrderService.controller;

import com.example.OrderService.dto.OrderRequest;
import com.example.OrderService.dto.OrderResponse;
import com.example.OrderService.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;
    @PostMapping("/postorder")
    public ResponseEntity<Long> placingOrder(@RequestBody OrderRequest orderRequest)
    {
        log.info("placing order is called");
       long orderId=orderServiceImpl.placeOrder(orderRequest,orderRequest.getLoginDto());
       return new ResponseEntity<>(orderId, HttpStatus.OK);

    }
    @GetMapping("/getorderdetails/{orderId}")
    public OrderResponse gettingOrderDetails(@PathVariable("orderId") long orderId)
    {
        log.info("gettingOrderDetails is called ");
        return orderServiceImpl.getOrderDetails(orderId);
    }

}
