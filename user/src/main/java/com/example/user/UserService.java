package com.example.user;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RestTemplate restTemplate;

    public String getData() {
        // Team team = GET team-service/{userId}/teams
        String url = String.format("http://localhost:8000/order/%s/teams", 1);
        System.out.println("request url is : " + url);
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );
        return response.getBody();
    }


}
