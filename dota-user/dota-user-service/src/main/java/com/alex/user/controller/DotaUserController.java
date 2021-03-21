package com.alex.user.controller;

import com.alex.common.exceptions.BusinessException;
import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


@RestController
public class DotaUserController implements IFeignDotaUser{


    @Override
    public RJson<UserVo> loginByWechatToken(String token) {
        return RJson.ok(new UserVo().setWechatToken("123"));
    }

    @Override
    public RJson<UserVo> loginBySteamToken(String token) {
        return null;
    }

    @Override
    public RJson<UserVo> updateById(UserQO qo) {
        return null;
    }

    @Override
    public RJson<String> deleteById(Long id) {
        return null;
    }

    @Override
    public RJson<UserVo> getByUserNo(Long userNo) {
        return null;
    }

    @Override
    public RJson<UserVo> getByMobile(String mobile) {
        return null;
    }
}
