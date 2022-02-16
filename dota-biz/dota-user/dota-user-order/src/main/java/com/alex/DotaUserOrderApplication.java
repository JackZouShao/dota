package com.alex;

import com.alex.cache.annotation.EnableDotaCache;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringCloudApplication
@EnableFeignClients
@EnableDotaCache
@EnableAspectJAutoProxy
public class DotaUserOrderApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DotaUserOrderApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DotaUserOrderApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        userAge = applicationContext.getEnvironment().getProperty("spring.application.name");
        System.err.println("user name :"+userName+"; age: "+userAge);
    }

}
