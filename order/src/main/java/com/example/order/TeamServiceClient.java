package com.example.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "team")
public interface TeamServiceClient {
    @GetMapping("/{userId}/teams")
    TeamResponseData getTeam(@PathVariable("userId") Long id);

}
