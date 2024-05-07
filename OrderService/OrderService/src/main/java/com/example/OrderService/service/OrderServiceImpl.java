package com.example.OrderService.service;


import com.example.OrderService.dto.*;
import com.example.OrderService.entity.Orders;
import com.example.OrderService.exception.OrderCustomException;
import com.example.OrderService.externalservice.PaymentService;
import com.example.OrderService.externalservice.ProductService;
import com.example.OrderService.externalservice.UserLogin;
import com.example.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.Instant;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrderServiceImpl  implements OrderService {

    private  final ProductService productservice;

    private  final PaymentService paymentservice;
    private final UserLogin userLogin;
    @Autowired
    private OrderRepository orderRepository;

//    private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest,LoginDto loginDto) {
        ResponseEntity<String> authResponse=userLogin.authenticateUser(loginDto);

        log.info("calling productService from feignclient");

        log.info("calling payment service to complete paymemt");

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(orders.getOrderId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getAmount())
                .build();
        String orderStatus = null;
        try {
            paymentservice.doPayment(paymentRequest);
            log.info("OrderServiceImpl | placeOrder | Payment done Successfully. Changing the Oder status to PLACED");
            orderStatus="PLACED";
        }catch (Exception e){
            log.error("OrderServiceImpl | placeOrder | Error occurred in payment. Changing order status to PAYMENT_FAILED");
            orderStatus="PAYMENT_FAILED";
        }
        orders.setOrderStatus(orderStatus);
        orderRepository.save(orders);
        log.info("order done successfully id is:{}", orders.getId());
        return orders.getId();
    }









    @Override
    public OrderResponse getOrderDetails(long orderId) {
        log.info("getOrderDetails is called");
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderCustomException("order not found by this id", "NOT_FOUND", 404));

        log.info("OrderServiceImpl | getOrderDetails | Invoking Product service to fetch the product for id: {}", order.getId());
//       ProductResponse productResponse=restTemplate.getForObject("http://ProductService/product/"+order.getId(),ProductResponse.class);
//
//        log.info("getProductDetails | getting payment details from paymentService");
//        PaymentResponse paymentResponse = restTemplate.getForObject("http://Payment-Service/payment/" + order.getOrderId(),
//                PaymentResponse.class);

        ProductResponse productResponse=productservice.getProductbyid(order.getId());
PaymentResponse paymentResponse=paymentservice.getPaymentDetails(order.getOrderId());
        ProductDetails productDetails = ProductDetails.builder()
                .name(productResponse.getName())
                .id(productResponse.getId())
                .description(productResponse.getDescription())
                .price(productResponse.getPrice())
                .build();

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .paymentId(paymentResponse.getPaymentId())
                .paymentDate(paymentResponse.getPaymentDate())
                .paymentStatus(paymentResponse.getPaymentStatus())
                .paymentMode(paymentResponse.getPaymentMode())
                .build();

        OrderResponse orderResponse=OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .quantity(order.getQuantity())
                .build();
        return orderResponse;
    }

}















