package com.example.dotasecuritydemo.config;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0.0
 * @className MyAuthenticationDetails.java
 * @author: yz
 * @date: 2022/1/27 16:57
 */
public class MyAuthenticationDetails extends WebAuthenticationDetails {
    private final String code ;

    public MyAuthenticationDetails(HttpServletRequest request) {
        super(request);
        code = request.getParameter("code");
        System.out.println(code);
    }
    public boolean isPassed(){
        System.out.println(code);
        return true;
    }
}
