package com.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringCloudApplication
public class DotaUserServiceApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DotaUserServiceApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        String nack = applicationContext.getEnvironment().getProperty("dota.nacos.discovery.server");;
        System.out.println(userAge  + "-" + userName + "-" + nack + "-" );
    }
}
