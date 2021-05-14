package com.alex.redis;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.spring.starter.RedissonProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.IOException;

/**
 * @version 1.0.0
 * @className Configuration.java
 * @author: yz
 * @date: 2021/5/14 16:35
 */
@EnableConfigurationProperties({RedisProperties.class})
public class RedisConfiguration {

    @Bean
    public RedisSerializer<String> redisKeySerializer(){
        return RedisSerializer.string();
    }

    @Bean
    public RedisSerializer<Object> redisValueSerializer(){
        return RedisSerializer.json();
    }

    @Bean
    public RedisTemplate <String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory,
                                                        RedisSerializer<String> redisKeySerializer,
                                                        RedisSerializer<Object> redisValueSerializer){
        RedisTemplate <String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setDefaultSerializer(redisValueSerializer);
        redisTemplate.setKeySerializer(redisKeySerializer);
        redisTemplate.setHashKeySerializer(redisKeySerializer);
        redisTemplate.setValueSerializer(redisValueSerializer);
        redisTemplate.setHashValueSerializer(redisValueSerializer);

        // 设置后属性处要执行的行为
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(RedissonProperties  redissonProperties) throws IOException {
        Config config = new Config();
        config.useSingleServer();
        config.setCodec(new JsonJacksonCodec());
        return Redisson.create();
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations zSetOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }

}
