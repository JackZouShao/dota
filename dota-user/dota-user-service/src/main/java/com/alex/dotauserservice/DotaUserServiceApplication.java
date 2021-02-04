package com.alex.dotauserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringCloudApplication
@EnableSwagger2
public class DotaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotaUserServiceApplication.class, args);
    }
}
