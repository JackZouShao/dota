package com.alex.order.controller;

import com.alex.common.util.R;
import com.alex.redis.RedisUtils;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.interfaces.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("order")
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ControllerOrder {
    
    @Resource
    private RedissonClient redissonClient;

    @Resource
    private ValueOperations<String, String> valueOperations;

    @Resource
    private RedisUtils redisUtils;

    private final IFeignDotaUser feignDotaUser;

    @GetMapping("/getUser")
    @ApiOperation("获取用户 sentinel 测试")
    public R<UserVo> getUser(){
        R<UserVo> byUserNo = feignDotaUser.getByUserNo(123L);
        return byUserNo == null ? R.ok(new UserVo()) : byUserNo;
    }
}
