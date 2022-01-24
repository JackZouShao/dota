package com.alex.order.config;

import com.alex.common.advice.CustomSentinelBlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0
 * @className Config.java
 * @author: yz
 * @date: 2022/1/23 13:11
 */
@Configuration
public class Config {

    @Bean
    public BlockExceptionHandler customSentinelBlockExceptionHandler(){
        return new CustomSentinelBlockExceptionHandler();
    }

}
