package com.alex.order.controller;

import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("订单")
@RestController
@RequestMapping("/test")
public class Controller {


    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<String> order(){
        return null;
    }
}
