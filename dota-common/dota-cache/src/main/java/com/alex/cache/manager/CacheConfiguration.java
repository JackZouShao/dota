package com.alex.cache.manager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0
 * @className CacheConfiguration.java
 * @author: yz
 * @date: 2021/5/14 14:32
 */

public class CacheConfiguration {

    @Bean
    @ConditionalOnBean
    public Cache cache(){
        return null;
    }

    @Bean
    public CacheOperation cacheGetOperation(){
        return new CacheGetOperation();
    }

    @Bean
    public CacheOperation cacheInvalidateOperation(){
        return new CacheInvalidateOperation();
    }

    @Bean
    public CacheOperationAop cacheOperationAop(
            @Qualifier("cacheGetOperation") CacheOperation cacheGetOperation,
            @Qualifier("cacheInvalidateOperation") CacheOperation cacheInvalidateOperation){

        return new CacheOperationAop(cacheGetOperation, cacheInvalidateOperation);
    }

}
