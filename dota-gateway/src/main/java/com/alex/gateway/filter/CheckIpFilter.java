package com.alex.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 自定义过滤器
 * @version 1.0.0
 * @className CheckIpFilter.java
 * @author: yz
 * @date: 2021/9/21 09:06
 */
@Slf4j
@Order(-1)
@Component
public class CheckIpFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        List<String> token = exchange.getRequest().getHeaders().get("token");
        log.info("token : {}", token);
//        if(token.isEmpty()){
//            return null;
//        }
        return chain.filter(exchange);
    }
}
