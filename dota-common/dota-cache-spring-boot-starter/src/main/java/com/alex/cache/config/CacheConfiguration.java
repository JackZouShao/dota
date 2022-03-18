package com.alex.cache.config;

import com.alex.cache.manager.Cache;
import com.alex.cache.manager.CacheOperationAop;
import com.alex.cache.manager.DefaultCache;
import com.alex.cache.operation.CacheGetOperation;
import com.alex.cache.operation.CacheInvalidateOperation;
import com.alex.cache.operation.CacheOperation;
import com.alex.cache.operation.CachePutOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @version 1.0.0
 * @className CacheConfiguration.java
 * @author: yz
 * @date: 2021/5/14 14:32
 */
public class CacheConfiguration {

    /**
     * Cache 默认实现，如果用户自定义了
     * 那么使用用户定义的实现
     * @return Cache 实体
     */
    @Bean(name = "cache")
    @ConditionalOnMissingBean
    public Cache cache(){
        return new DefaultCache();
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
    public CacheOperation cachePutOperation(){
        return new CachePutOperation();
    }

    @Bean
    public CacheOperationAop cacheOperationAop(
            @Qualifier("cacheGetOperation") CacheOperation cacheGetOperation,
            @Qualifier("cacheInvalidateOperation") CacheOperation cacheInvalidateOperation,
            @Qualifier("cachePutOperation") CacheOperation cachePutOperation){
        return new CacheOperationAop(cachePutOperation, cacheInvalidateOperation, cacheGetOperation);
    }
}
