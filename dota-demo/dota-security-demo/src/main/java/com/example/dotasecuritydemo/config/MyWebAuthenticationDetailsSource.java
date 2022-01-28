package com.example.dotasecuritydemo.config;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0.0
 * @className MyWebAuthenticationDetailsSource.java
 * @author: yz
 * @date: 2022/1/27 17:01
 */
@Component
public class MyWebAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, MyAuthenticationDetails> {
    @Override
    public MyAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new MyAuthenticationDetails(context);
    }
}
