package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.redis.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
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

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<String> order(){
        RBucket<String> bucket = redissonClient.getBucket("1");
        bucket.set("123");

        redisUtils.set("s", new Person("susan", 12));
        System.out.println(redisUtils.get("s"));
        System.out.println(redisUtils.get("s", Person.class));
        System.out.println(redisUtils.get("s", Person.class, 1));
        return null;
    }
}

