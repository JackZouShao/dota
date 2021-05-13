package com.alex.cache.manager;

import com.alex.cache.constants.CacheType;
import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @className AnnotationParam.java
 * @author: yz
 * @date: 2021/5/13 19:30
 */
@Data
@Builder
public class AnnotationParam {

    private String key;
    private String prefix;
    private CacheType dataType;
    private String keyGenerator;
    private String cacheManager;
    private String cacheResolver;
    private String hashKey;
    private int expireTime;
    private TimeUnit timeUnit;
    private int end;
    private int start;

    /**
     * 将前缀和注解的key 组成缓存的key
     * @param id
     */
    protected void setCacheKey(String id){
        this.key = prefix + id;
    }


}
