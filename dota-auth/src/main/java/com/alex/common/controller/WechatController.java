package com.alex.common.controller;

import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Wechat 第三方登录相关处理类")
@RestController
@RequestMapping("/wechat")
public class WechatController {

    public RJson<String> getToken(){
        return RJson.ok();
    }

}
