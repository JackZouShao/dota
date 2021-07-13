package com.alex.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @version 1.0.0
 * @className Book.java
 * @author: yz
 * @date: 2021/6/6 20:11
 */
@Profile(value = "dev")
@Component
@Slf4j
public class Book {
    public Book(){
        System.out.println("Book constructor 方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("Book's postConstruct 方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Book's destroy 方法");
    }
}
