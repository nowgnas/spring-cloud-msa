package com.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/data")
    public ResponseEntity<String> getData() {
        System.out.println("user data controller ");
        String data = userService.getData();
        System.out.println(data + "slfjslk");
        return ResponseEntity.ok(data);
    }
}
