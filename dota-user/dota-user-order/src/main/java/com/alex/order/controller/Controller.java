package com.alex.order.controller;

import com.alex.common.util.RJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("订单")
@RestController
@RequestMapping("/test")
public class Controller {

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private ValueOperations valueOperations;

    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<String> order(){
        RBucket<String> bucket = redissonClient.getBucket("1");
        bucket.set("123");
//        valueOperations.set("1", "123");
        System.out.println(valueOperations.get("1"));
        return null;
    }
}
