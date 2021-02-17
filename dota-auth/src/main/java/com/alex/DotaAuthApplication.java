package com.alex;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringCloudApplication
@EnableSwagger2WebMvc
public class DotaAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DotaAuthApplication.class);
    }
}
