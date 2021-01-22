package com.alex.dotaeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.misc.Launcher;

import java.util.Arrays;

@EnableEurekaServer
@SpringBootApplication
public class DotaEurekaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DotaEurekaApplication.class, args);
//        System.out.println(" eureka start success, please start dota-config");

        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
         System.out.println(DotaEurekaApplication.class.getClassLoader().getClass().getName());
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader parent = systemClassLoader.getParent();
        Arrays.stream(Launcher.getBootstrapClassPath().getURLs()).peek(System.out::println);
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(System.getProperty("java.class.path"));
    }

    private int get(String age){
        return 1;
    }

}
