package com.alex.order.controller;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.interfaces.vo.UserVo;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("order")
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class ControllerOrder {

    private final IFeignDotaUser feignDotaUser;

    @GetMapping("/getUser")
    @ApiOperation("获取用户 sentinel 测试")
    public RJson<UserVo> getUser(){
        RJson<UserVo> byUserNo = feignDotaUser.getByUserNo(123L);
        return byUserNo == null ? RJson.ok(new UserVo()) : byUserNo;
    }
}
