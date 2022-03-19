package com.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

import java.util.concurrent.TimeUnit;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class DotaGatewayApplication  {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DotaGatewayApplication.class, args);
    }
}
