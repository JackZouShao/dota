package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.order.DemoService;
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
    private ValueOperations<String, String> valueOperations;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private DemoService demoService;

    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<Person> order(){
//        redisUtils.set("p:s", new Person("susan", 12));
        return RJson.ok(demoService.getPerson()) ;
    }
}

