package com.alex.user.controller;

import com.alex.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0.0
 * @className TestController.java
 * @author: yz
 * @date: 2022/3/15 00:23
 */
@Api("user")
@RestController
@RequestMapping("/user")
public class TestController {

    @ApiOperation("测试")
    @GetMapping("/test")
    public R<String> testApi(){
        return R.ok();
    }
}
