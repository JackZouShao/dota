package com.alex;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import java.io.Serializable;

@SpringCloudApplication

public class DotaAuthApplication implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(DotaAuthApplication.class, args);
    }
}
