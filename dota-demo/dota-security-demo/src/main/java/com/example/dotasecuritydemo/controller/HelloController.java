package com.example.dotasecuritydemo.controller;

import com.example.dotasecuritydemo.config.MyAuthenticationDetails;
import com.google.code.kaptcha.Producer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @version 1.0.0
 * @className HelloController.java
 * @author: yz
 * @date: 2022/1/26 15:27
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        MyAuthenticationDetails myDetails = (MyAuthenticationDetails) authentication.getDetails();
        System.out.println(myDetails.getRemoteAddress());
        return "hello";
    }

    @Resource
    public Producer producer;

    @GetMapping("/vc.jpg")
    public void getVerifyCode(HttpServletResponse resp, HttpSession session) throws IOException {
        resp.setContentType("image/jpeg");
        String text = producer.createText();
        session.setAttribute("verify_code", text);
        BufferedImage image = producer.createImage(text);
        try(ServletOutputStream out = resp.getOutputStream()) {
            ImageIO.write(image, "jpg", out);
        }
    }
}
