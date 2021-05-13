package com.alex.cache.manager;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * cache 的操作的接口
 * @version 1.0.0
 * @className Cache.java
 * @author: yz
 * @date: 2021/5/13 19:50
 */
public interface Cache {

    String get(String key);
    void set(String key, String value);
    void set(String key, String value, int expireTime, TimeUnit timeUnit);

    String hget(String key);
    void hset(String key, String value);
    void hset(String key, String value, int expireTime, TimeUnit timeUnit);

    void setExpireTime(String key, int expireTime, TimeUnit timeUnit);
    void invalidate(Collection<String> keys);
}
