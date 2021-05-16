package com.alex;

import com.alex.cache.annotation.EnableDotaCache;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringCloudApplication
@EnableFeignClients
@EnableDotaCache
@EnableAspectJAutoProxy
public class DotaUserOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DotaUserOrderApplication.class, args);
    }

}
