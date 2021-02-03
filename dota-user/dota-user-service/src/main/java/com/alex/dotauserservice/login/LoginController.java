package com.alex.dotauserservice.login;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping(value = "/login")
@RestController
@RefreshScope
public class LoginController {

    @Value("${x}")
    private String x;
    @GetMapping(value = "/test")
    public String test(){
        System.out.println(x);
        return ("123");
    }

}
