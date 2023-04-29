package com.example.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KafkaDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDiscoveryApplication.class, args);
    }

}
