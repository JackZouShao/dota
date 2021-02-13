package com.alex.dota;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DotaGatewayApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DotaGatewayApplication.class, args);

    }

//    @Value("${x}")
    private String x;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(x);
    }
}
