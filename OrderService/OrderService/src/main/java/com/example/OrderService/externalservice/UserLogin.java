package com.example.OrderService.externalservice;

import com.example.OrderService.dto.LoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="User-Login", url="http://localhost:8090/api/auth")
public interface UserLogin {
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto);

}

