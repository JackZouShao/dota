package com.alex.dota.feign;

import com.alex.dota.login.UserInfo;
import io.swagger.annotations.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Api("用户模块")
@RestController
@RequestMapping("/login")
@RefreshScope
public class LoginController {




    @ApiOperation(value = "test", notes = "notes")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "s", dataType = "string", defaultValue = "123"),
            @ApiImplicitParam(value = "s2", dataType = "string",defaultValue = "sss")
    })
    @GetMapping(value = "/test")
    public String test(){

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

