package com.alex.auth.component;

import com.alex.auth.domain.SecurityUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT内容增强器
 * 扩展
 * JWT
 * 中的存储内容
 * @version 1.0.0
 * @className JwtTokenEnhancer.java
 * @author: yz
 * @date: 2022/1/23 23:47
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    /**
     * 设置用户id 到JWT
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        // 获取当前用户 并把用户id 存入jwt
        SecurityUser securityUser = (SecurityUser) oAuth2Authentication.getPrincipal();
        Map<String,Object> info = new HashMap<>();
        info.put("id", securityUser.getId());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
