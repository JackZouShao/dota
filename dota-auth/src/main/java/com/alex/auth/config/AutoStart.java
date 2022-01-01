package com.alex.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @className AutoStart.java
 * @author: yz
 * @date: 2021/12/29 00:17
 */
@Component
public class AutoStart implements CommandLineRunner {

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String nacos;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(nacos);
    }
}
