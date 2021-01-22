package com.alex.dotaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DotaConfigApplication implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DotaConfigApplication.class, args);
        Thread.sleep(1000);
    }


    @Override
    public void run(String... args) throws Exception {
        Thread.currentThread().setDaemon(true);

    }
}
