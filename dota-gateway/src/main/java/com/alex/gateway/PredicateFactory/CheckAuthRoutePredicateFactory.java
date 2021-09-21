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
    public Predicate<ServerWebExchange> apply(Consumer<Config> consumer) {
        return super.apply(consumer);
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Consumer<Config> consumer) {
        return super.applyAsync(consumer);
    }

    @Override
    public void beforeApply(Config config) {
        super.beforeApply(config);
    }

    @Override
    public AsyncPredicate<ServerWebExchange> applyAsync(Config config) {
      return super.applyAsync(config);
    }

    @Override
    public String name() {
        return super.name();
    }

    @Override
    public Class<Config> getConfigClass() {
        return super.getConfigClass();
    }

    @Override
    public Config newConfig() {
        return super.newConfig();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public ShortcutType shortcutType() {
        return super.shortcutType();
    }

    @Override
    public String shortcutFieldPrefix() {
        return super.shortcutFieldPrefix();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
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
