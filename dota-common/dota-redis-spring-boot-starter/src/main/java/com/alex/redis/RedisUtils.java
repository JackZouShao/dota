package com.alex.redis;

import com.alibaba.fastjson.JSON;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @className RedisUtils.java
 * @author: yz
 * @date: 2021/5/15 14:49
 */
@RequiredArgsConstructor(access = AccessLevel.PUBLIC, staticName = "of")
public class RedisUtils {

    private final RedisTemplate redisTemplate;

    private final ValueOperations<String, Object> valueOperations;

    public final static long EXPIRE_TIME = 60 * 60;

    public final static long NOT_EXPIRE = -1l;

    public void set(String key, Object value){
        set(key, value, NOT_EXPIRE);
    }

    public void set(String key, Object value, long expireTime) {
        if (expireTime == NOT_EXPIRE) {
            valueOperations.set(key, JSON.toJSONString(value));
            return;
        }
        valueOperations.set(key, JSON.toJSONString(value), expireTime, TimeUnit.SECONDS);
    }

    public String get(String key, long expire){
        // TODO LUA
        String value = (String) valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ?  null : value;
    }

    public String get(String key){
       return get(key, NOT_EXPIRE);
    }


    public <T> T get(String key, Class<T> klass){
        return get(key, klass, NOT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire){
        String value = (String) valueOperations.get(key);
        if(expire != NOT_EXPIRE){
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ?  null : JSON.parseObject(value, clazz);
    }
}
