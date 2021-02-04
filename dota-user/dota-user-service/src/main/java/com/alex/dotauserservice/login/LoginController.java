package com.alex.dotauserservice.login;

import com.google.common.collect.Maps;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Api("用户模块")
@RequestMapping(value = "/login")
@RestController
@RefreshScope
public class LoginController {

    @Value("${x}")
    private String x;


    @ApiOperation(value = "test", tags = "tags", notes = "notes")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "s", dataType = "string", defaultValue = "123"),
            @ApiImplicitParam(value = "s2", dataType = "string",defaultValue = "sss")
    })
    @GetMapping(value = "/test", params = {"s", "s2"})
    public String test(String s, String s2){
        System.out.println(x);
        System.out.println(s);
        System.out.println(s2);
        return ("123");
    }


    @ApiOperation(value = "userinfo 测试")
    @PostMapping(value = "/test2")
    @ApiImplicitParam(value = "Userinfo")
    public String test(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        return ("123");
    }

}

