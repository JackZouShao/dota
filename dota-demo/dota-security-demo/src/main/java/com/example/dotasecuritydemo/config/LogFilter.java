package com.example.dotasecuritydemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0.0
 * @className LogFilter.java
 * @author: yz
 * @date: 2022/1/26 21:34
 */
public class LogFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(!request.getMethod().equals("POST")){
            throw new RuntimeException("POST");
        }

        if(request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)){
            Map<String, String> data = new HashMap<>();
            try {
                data = (Map<String, String>) new ObjectMapper().readValue(request.getInputStream(), Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String username = data.get(getUsernameParameter()) == null ? "" : data.get(getUsernameParameter()).trim();
            String password = data.get(getPasswordParameter()) == null ? "" : data.get(getPasswordParameter());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            setDetails(request, usernamePasswordAuthenticationToken);
            return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
        }
        return super.attemptAuthentication(request, response);

    }
}
