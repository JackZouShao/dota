package com.alex.cache.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @className CacheGetAndPut.java
 * @author: yz
 * @date: 2021/5/13 19:03
 *  * @version 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheGetAndPut {

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

}
