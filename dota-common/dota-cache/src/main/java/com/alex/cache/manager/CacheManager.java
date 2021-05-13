package com.alex.cache.manager;

/**
 * 缓存接口
 * 策略模式
 * @version 1.0.0
 * @className Cachemanager.java
 * @author: yz
 * @date: 2021/5/13 19:25
 */
public interface CacheManager {

    /**
     * return the name of cache
     */
    String getName();

    Cache getCache(Object key);

}
