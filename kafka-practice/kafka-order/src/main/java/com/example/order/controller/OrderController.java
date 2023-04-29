package com.example.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("order info success");
    }
}
