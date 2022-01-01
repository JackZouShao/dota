package com.alex;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.Arrays;

@SpringCloudApplication
@EnableFeignClients
public class DotaAuthApplication implements Serializable {



    public static void main(String[] args) {
        Arrays.stream(args).forEach(System.out::println);
        SpringApplication.run(DotaAuthApplication.class, args);

    }
}
