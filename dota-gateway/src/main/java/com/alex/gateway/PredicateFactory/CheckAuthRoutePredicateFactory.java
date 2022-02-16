package com.alex.gateway.PredicateFactory;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.cloud.gateway.handler.AsyncPredicate;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 自定义断言工厂
 * @version 1.0.0
 * @className CheckAuthRoutePredicateFactory.java
 * @author: yz
 * @date: 2021/9/21 01:06
 */
@Slf4j
//@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public CheckAuthRoutePredicateFactory(Class<Config> configClass) {
        super(configClass);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (exchange) ->{
            log.info("调用CheckAuthRoutePredicateFactory" + config.getName());
            return StrUtil.equals(config.getName(), "fox") ? true : false;
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("list");
    }

    @Data
    public static class Config{
        private String name;
    }
}
