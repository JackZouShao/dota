package com.alex.dotauserservice.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/login")
@RestController
public class LoginController {
    @Value("${x}")
    private String x;
    @GetMapping(value = "/test")
    public void test(){
        System.out.println("login");
    }

}
