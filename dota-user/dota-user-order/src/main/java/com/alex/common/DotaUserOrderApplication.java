package com.alex.common;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class DotaUserOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotaUserOrderApplication.class, args);
    }

}
