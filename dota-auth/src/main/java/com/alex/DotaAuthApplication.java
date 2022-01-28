package com.alex;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

@SpringCloudApplication
@EnableDiscoveryClient
public class DotaAuthApplication implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(DotaAuthApplication.class, args);
    }
}
