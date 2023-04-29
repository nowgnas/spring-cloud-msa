package com.example.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("user info success");
    }

    @GetMapping("message")
    public ResponseEntity<String> message(@Value("${dev.message}") String message) {
        return ResponseEntity.ok(message);
    }
}
