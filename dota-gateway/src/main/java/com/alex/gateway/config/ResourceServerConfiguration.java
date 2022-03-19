package com.alex.gateway.config;

import cn.hutool.core.util.ArrayUtil;
import com.alex.common.constants.AuthConstant;
import com.alex.gateway.authorization.AuthorizationManager;
import com.alex.gateway.component.RestAuthenticationEntryPoint;
import com.alex.gateway.component.RestfulAccessDeniedHandler;
import com.alex.gateway.filter.IgnoreUrlsRemoveJwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * OAuth资源配置
 * 资源服务器，即服务提供商存放用户生成的资源的服务器。它与授权服务器，可以 是同一台服务器，也可以是不同的服务器
 * 对网关服务进行配置安全配置，由于Gateway使用的是WebFlux，所以需要使用@EnableWebFluxSecurity注解开启；
 * @version 1.0.0
 * @className ResourceServerConfiguration.java
 * @author: yz
 * @date: 2022/1/23 22:32
 */
@Configuration
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class ResourceServerConfiguration {

    private final AuthorizationManager authorizationManager;
    private final IgnoreUrlsConfig ignoreUrlsConfig;
    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    private final IgnoreUrlsRemoveJwtFilter ignoreUrlsRemoveJwtFilter;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        // Configures the Converter to use for converting a Jwt into an AbstractAuthenticationToken
        http.oauth2ResourceServer().jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter());

        // 自定义处理JWT请求头过期或签名错误的结果
        http.oauth2ResourceServer().authenticationEntryPoint(restAuthenticationEntryPoint);
        // 白名单路径， 直接移除JWT请求头
        http.addFilterBefore(ignoreUrlsRemoveJwtFilter, SecurityWebFiltersOrder.AUTHORIZATION);
        http.authorizeExchange()
                .pathMatchers(ArrayUtil.toArray(ignoreUrlsConfig.getUrls(), String.class)).permitAll() // 白名单配置
                .anyExchange().access(authorizationManager)//鉴权管理器配置
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler) // 处理未授权
                .authenticationEntryPoint(restAuthenticationEntryPoint) // 处理未认证
                .and().csrf().disable();
        return http.build();

    }
    /**
     * @return
     * @link https://blog.csdn.net/qq_24230139/article/details/105091273
     * ServerHttpSecurity没有将jwt中authorities的负载部分当做Authentication
     * 需要把jwt的Claim中的authorities加入
     * 方案：重新定义权限管理器，默认转换器JwtGrantedAuthoritiesConverter
     */
    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter(){

        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AuthConstant.AUTHORITY_PREFIX);
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(AuthConstant.AUTHORITY_CLAIM_NAME);

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);

    }

}
