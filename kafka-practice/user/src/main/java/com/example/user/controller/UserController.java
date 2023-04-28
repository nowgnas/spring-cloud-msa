package com.example.user.controller;

import com.example.user.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("info")
    public ResponseEntity<User> getInfo() {
        User user = new User();
        user.setName("sangwon");
        return ResponseEntity.ok(user);
    }

    @PostMapping("join")
    public ResponseEntity<String> create(@RequestBody User user) {
        return ResponseEntity.ok("success");
    }
}
