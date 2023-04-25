package com.example.user;

import com.example.user.domain.dto.UserCreateData;
import com.example.user.domain.dto.UserResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public UserResponseData createUser(@RequestBody UserCreateData userCreateData) {
        return userService.save(userCreateData);
    }

    @GetMapping("/users/{userId}")
    public UserResponseData getUser(@PathVariable("userId") Long id) {
        return userService.getUserById(id);
    }
}
