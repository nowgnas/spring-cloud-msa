package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KafkaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaUserApplication.class, args);
    }

}
