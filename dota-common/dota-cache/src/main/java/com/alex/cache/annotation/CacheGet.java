package com.alex.cache.annotation;

import com.alex.cache.constants.CacheType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @className CacheGet.java
 * @author: yz
 * @date: 2021/5/13 18:56
 * @since 1.1.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheGet {

    /**
     * 缓存前缀
     * @return
     */
    String prefix() default "";

    /**
     * 缓存的key
     * @return
     */
    String key() default "";

    /**
     * 过期时间
     * @return
     */
    int expireTime() default 0;

    /**
     * 过期时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.HOURS;

    CacheType cacheType() default CacheType.STRING;

    String hashKey() default "";
}
