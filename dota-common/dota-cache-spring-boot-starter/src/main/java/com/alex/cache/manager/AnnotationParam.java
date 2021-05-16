package com.alex.cache.manager;

import com.alex.cache.constants.CacheType;
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
    private Class<?> returnType;

    /**
     * concat prefix and key
     * @param id real cache key
     */
    public void setCacheKey(String id){
        this.key = prefix + id;
    }


}
