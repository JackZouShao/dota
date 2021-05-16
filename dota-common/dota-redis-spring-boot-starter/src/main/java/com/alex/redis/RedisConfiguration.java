package com.alex.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.io.IOException;

/**
 * redisson 主要用于分布式锁、优先等级队列等
 * RedisTemplate 主要用于普通的缓存操作
 * 两者的序列化方法不同 不能互用
 *
 * @version 1.0.0
 * @className Configuration.java
 * @author: yz
 * @date: 2021/5/14 16:35
 */
@EnableConfigurationProperties({RedisProperties.class})
public class RedisConfiguration {

    /**
     * redisson 主要用于分布式锁、优先等级队列等
     * 分为 单服务器 集群和哨兵模式 ，不同模式根据参数配置不同生效
     * @return {@link RedissonClient}
     */
    @Bean(name = "redissonClient", destroyMethod = "shutdown")
    @ConditionalOnExpression("#{'singleServer'.equals(environment['spring.redisson.mode'])}")
    public RedissonClient singleServerClient() throws IOException {
        Config config = Config.fromYAML(RedisConfiguration.class.getClassLoader().getResource("redisson-config.yml"));
        return Redisson.create(config);
    }


    /**
     * cluster
     * @return  {@link RedissonClient}
     */
    @Bean(name = "redissonClient", destroyMethod = "shutdown")
    @ConditionalOnExpression("#{'cluster'.equals(environment['spring.redisson.mode'])}")
    public RedissonClient clusterClient() throws IOException {
        Config config = Config.fromYAML(RedisConfiguration.class.getClassLoader().getResource("redisson-config.yml"));
        return Redisson.create(config);
    }

    /**
     * sentinel
     * @return {@link RedissonClient}
     */
    @Bean(name = "redissonClient", destroyMethod = "shutdown")
    @ConditionalOnExpression("#{'sentinel'.equals(environment['spring.redisson.mode'])}")
    public RedissonClient sentinelClient() throws IOException {
        Config config = Config.fromYAML(RedisConfiguration.class.getClassLoader().getResource("redisson-config.yml"));
        return Redisson.create(config);
    }


    @Bean
    public RedisSerializer<String> redisKeySerializer(){
        return RedisSerializer.string();
    }

    @Bean
    public RedisSerializer<Object> redisValueSerializer(){
        return RedisSerializer.json();
    }

    /**
     * RedisTemplate 主要用于普通的缓存操作
     * @param redisConnectionFactory 连接工厂
     * @param redisKeySerializer key 序列器
     * @param redisValueSerializer value 序列器
     * @return RedisTemplate
     */
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
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }

    @Bean
    public RedisUtils redisUtils(RedisTemplate<String, Object> redisTemplate, ValueOperations<String, Object> valueOperations){
       return RedisUtils.of(redisTemplate, valueOperations);
    }

}
