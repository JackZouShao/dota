package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api("order")
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ControllerOrder {

    private final IFeignDotaUser feignDotaUser;

    @GetMapping("/2")
    @ApiOperation("2")
    public int get(){
        return 2;
    }



    @GetMapping("/getUser")
    @ApiOperation("获取用户 sentinel 测试")
    public UserVo getUser(){

        RJson<UserVo> byUserNo = feignDotaUser.getByUserNo(123l);
        return byUserNo.getData();

    }
}
