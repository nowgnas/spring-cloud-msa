package com.example.user;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8000")
public interface TeamServiceClient {
    @GetMapping("/order/{userId}/teams")
    TeamResponseData getTeam(@PathVariable("userId") Long id);
}
