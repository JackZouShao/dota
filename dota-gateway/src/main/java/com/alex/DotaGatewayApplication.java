package com.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DotaGatewayApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DotaGatewayApplication.class, args);
    }
}
