package com.alex.dotauserservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class DotaUserServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(DotaUserServiceApplication.class, args);
    }



    @Value("${test}")
    private String test;
    @Value("${v}")
    private String v;

    @Value("${x}")
    private String x;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(test);
        System.out.println(v);
        System.out.println(x);
    }
}
