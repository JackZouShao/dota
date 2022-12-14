package com.alex.auth.controller;


import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.token.Token;

@Api(tags = "Wechat 第三方登录相关处理类")
@RestController
@RequestMapping("/wechat")
@RequiredArgsConstructor
public class WechatController {

    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    @ApiOperation("获取微信token")
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public RJson<Token> getToken(){
        Token token = TokenAPI.token(appId, appSecret);
        return RJson.ok(token);
    }
}
