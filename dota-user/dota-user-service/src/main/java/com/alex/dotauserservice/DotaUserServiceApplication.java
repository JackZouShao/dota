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

    @Override
    public void run(String... args) throws Exception {

    }
}
