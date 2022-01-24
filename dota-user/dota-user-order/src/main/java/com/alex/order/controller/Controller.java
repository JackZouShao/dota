package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.order.service.DemoService;
import com.alex.user.feign.interfaces.vo.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Api("订单")
@RestController
@RequestMapping("/test")
public class Controller {

    @Value("${ex}")
    private String ex;

    @Resource
    private DemoService demoService;

    @PostConstruct
    public void init(){
        System.out.println(ex);
    }

    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<Person> order(){
        System.out.println(ex);
        return RJson.ok(demoService.getPerson()) ;
    }
}

