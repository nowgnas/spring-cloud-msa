package com.example.user.controller;

import com.example.user.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final KafkaProducer kafkaProducer;

    @GetMapping("info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("user info success");
    }

    @GetMapping("message")
    public ResponseEntity<String> message(@Value("${dev.message}") String message) {
        return ResponseEntity.ok(message);
    }

    @GetMapping("/send/{message}")
    public String send(@PathVariable String message) {
        kafkaProducer.send("order-topic", message);
        return message;
    }
}
