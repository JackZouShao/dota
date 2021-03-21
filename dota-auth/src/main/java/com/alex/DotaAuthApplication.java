package com.alex;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class DotaAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DotaAuthApplication.class);
    }
}
