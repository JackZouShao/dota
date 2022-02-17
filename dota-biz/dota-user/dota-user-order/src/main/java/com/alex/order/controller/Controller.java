package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.redis.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
    private com.alex.order.service.DemoService demoService;

    @ApiOperation("测试feign")
    @GetMapping("/get")
    public RJson<com.alex.user.feign.interfaces.vo.Person> order(){
        return RJson.ok(demoService.getPerson()) ;
    }
}

