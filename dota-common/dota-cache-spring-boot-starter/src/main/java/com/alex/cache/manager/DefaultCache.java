package com.alex.cache.manager;

import com.alex.redis.RedisUtils;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class DefaultCache implements Cache{

	@Resource
	private  RedisUtils redisUtils;

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public String get(String key) {
		return redisUtils.get(key);
	}

	@Override
	public <T> T get(String key, Class<T> clazz) {
		return redisUtils.get(key, clazz);
	}

	@Override
	public void set(String key, Object value) {
		redisUtils.set(key, value);
	}

	@Override
	public void set(String key, Object value, int expireTime, TimeUnit timeUnit) {
		redisUtils.set(key, value, expireTime, timeUnit);
	}

	@Override
	public String hget(String key) {
		return null;
	}

	@Override
	public void hset(String key, String value) {

	}

	@Override
	public void hset(String key, String value, int expireTime, TimeUnit timeUnit) {

	}

	@Override
	public void setExpireTime(String key, int expireTime, TimeUnit timeUnit) {
		redisTemplate.expire(key, expireTime, timeUnit);
	}

	@Override
	public Long invalidate(Collection<String> keys) {
		return redisTemplate.delete(keys);
	}

	@Override
	public Boolean invalidate(String key) {
		return redisTemplate.delete(key);
	}
}
