package com.alex.user.controller;

import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/123")
public class Contro {

    @GetMapping("/123")
    public RJson<String> test(){
        return RJson.failed("123");
    }
}
