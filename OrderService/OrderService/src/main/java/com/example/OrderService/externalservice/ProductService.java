package com.example.OrderService.externalservice;

import com.example.OrderService.dto.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ProductService",url="http://localhost:8081/product")
public interface ProductService {
    @PutMapping ("/reducequantity/{id}")

    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long id, @RequestParam long quantity);



    @GetMapping("/getpricebyid/{id}")
    public ResponseEntity<Long> getpricebyid(@PathVariable long id);

    @GetMapping("/byid/{id}")
    public ProductResponse getProductbyid(@PathVariable("id") long id);
}
