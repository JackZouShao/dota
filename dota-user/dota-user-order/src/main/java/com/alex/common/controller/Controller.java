package com.alex.common.controller;

import com.alex.common.feign.inteface.FeignLoginController;
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

    @Resource
    private FeignLoginController feignLoginController;


    @ApiOperation("测试feign")
    @GetMapping("/get")
    public String order(){
        return feignLoginController.test();
    }
}
