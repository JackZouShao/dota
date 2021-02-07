package com.dota.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("订单")
@RestController
@RequestMapping("/test")
public class Controller {

    @ApiOperation("获取订单")
    @GetMapping("/get")
    public String order(){
        return "order";
    }
}
