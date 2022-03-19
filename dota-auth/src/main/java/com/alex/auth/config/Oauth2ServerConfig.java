package com.alex.auth.config;

import com.alex.auth.component.JwtTokenEnhancer;
import com.alex.auth.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

/**
 *  配置授权服务器
 *  Oauth2  AuthorizationServer 配置，服务提供商专门用来处理认证授权的服务器。
 *  Oauth2 有四种角色
 * （1）Third-party application：第三方应用程序，又称"客户端"（client），即例子中的"云冲印"。
 * （2）HTTP service：HTTP服务提供商，简称"服务提供商"，即例子中的Google。
 * （3）Resource Owner：资源所有者，又称"用户"（user）。
 * （4）User Agent：用户代理，比如浏览器。
 * （5）Authorization server：授权服务器，即服务提供商专门用来处理认证授权的服务器。
 * （6）Resource server：资源服务器，即服务提供商存放用户生成的资源的服务器。它与授权服务器，可以是同一台服务器，也可以是不同,我们将其放入网关服务器
 * @version 1.0.0
 * @className Oauth2ServerConfig.java
 * @author: yz
 * @date: 2022/1/23 23:45
 */
@RequiredArgsConstructor
@EnableAuthorizationServer
@Configuration
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenEnhancer jwtTokenEnhancer;


    /**
     * OAuth2客户端
     * Third-party application：第三方应用程序，又称"客户端"（client），即例子中的"第三方应用"。
     * 我们这里不在数据库中，本地直接生成一个
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client-app")
                .secret(passwordEncoder.encode("5545125"))
                .scopes("all")
                .authorizedGrantTypes("password", "refresh_token") // password 密码模式
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(86400);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }

    /**
     * 授权服务器，即服务提供商专门用来处理认证授权的服务器。
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates);
        endpoints.authenticationManager(authenticationManager)// 使用密码模式需要配置
                .userDetailsService(userService)
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(enhancerChain)
        // refresh token有两种使用方式：重复使用(true)、非重复使用(false)，默认为true
        //      1 重复使用：access token过期刷新时， refresh token过期时间未改变，仍以初次生成的时间为准
        //      2 非重复使用：access token过期刷新时， refresh token过期时间延续，在refresh token有效期内刷新便永不失效达到无需再次登录的目的
                .reuseRefreshTokens(true)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

    }

    /**
     * 使用非对称加密算法对token签名
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }

    /**
     * 密钥库中获取密钥对(公钥+私钥)
     * 配置JWT使用的秘钥 非对称加密
     */
    @Bean
    public KeyPair keyPair(){
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "5545125".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwt", "5545125".toCharArray());
    }
}
