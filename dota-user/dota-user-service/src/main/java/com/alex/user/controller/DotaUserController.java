package com.alex.user.controller;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 用户服务
 */
@Slf4j
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
        log.info("查询 user info");
        return RJson.ok(new UserVo().setUserNo(123l));
    }

    @Override
    public RJson<UserVo> getByMobile(String mobile) {
        return null;
    }
}
