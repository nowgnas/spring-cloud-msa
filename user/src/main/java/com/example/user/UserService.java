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
    private final TeamServiceClient teamServiceClient;

    public TeamResponseData getData() {
        // Team team = GET team-service/{userId}/teams
        String url = String.format("http://order-service/order/%s/teams", 1);
        System.out.println("request url is : " + url);
        ResponseEntity<TeamResponseData> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<TeamResponseData>() {
                }
        );
        return response.getBody();
    }

    public TeamResponseData getTeam() {
        return teamServiceClient.getTeam(1L);
    }
}
