package com.example.dotasecuritydemo.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0.0
 * @className MyAuthenticationProvider.java
 * @author: yz
 * @date: 2022/1/27 15:13
 */
public class MyAuthenticationProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//        String code = request.getParameter("code");
//        System.out.println(code);
//        String verify_code = (String) request.getSession().getAttribute("verify_code");
//
        boolean passed = ((MyAuthenticationDetails) authentication.getDetails()).isPassed();
        super.additionalAuthenticationChecks(userDetails, authentication);
    }
}
