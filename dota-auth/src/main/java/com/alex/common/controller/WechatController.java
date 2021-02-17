package com.alex.common.controller;

import com.alex.common.util.RJson;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.ComponentAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

@Api("Wechat 第三方登录相关处理类")
@RestController
@RequestMapping("/wechat")
public class WechatController {

    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    @GetMapping("/token")
    public RJson<String> getToken(){

        // 获取Code
        Token token = TokenAPI.token(appId, appSecret);
        // 用code获取token

        // 将用户信息包装成JWT
        JwtBuilder jwtBuilder = Jwts.builder();

        return RJson.ok();
    }

}
