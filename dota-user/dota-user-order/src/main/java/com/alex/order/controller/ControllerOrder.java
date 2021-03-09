package com.alex.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("order")
@RestController
@RequestMapping("/order")
public class ControllerOrder {

    @GetMapping("/2")
    @ApiOperation("2")
    public int get(){
        return 2;
    }
}
