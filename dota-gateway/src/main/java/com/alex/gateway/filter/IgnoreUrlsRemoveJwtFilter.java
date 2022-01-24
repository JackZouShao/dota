package com.alex.gateway.filter;

import com.alex.gateway.config.IgnoreUrlsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * 白名单路径访问时需要移除JWT请求头
 * @version 1.0.0
 * @className IgnoreUrlsRemoveJwtFilter.java
 * @author: yz
 * @date: 2022/1/24 14:43
 */
@Component
@RequiredArgsConstructor
public class IgnoreUrlsRemoveJwtFilter implements WebFilter {

    private final IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain webFilterChain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri = request.getURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();

        List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if(antPathMatcher.match(ignoreUrl, uri.getPath())){
                // 设置认真字段为null
                request = exchange.getRequest().mutate().header("Authorization", "").build();
                exchange = exchange.mutate().request(request).build();
                return  webFilterChain.filter(exchange);
            }
        }
        return webFilterChain.filter(exchange);
    }
}
