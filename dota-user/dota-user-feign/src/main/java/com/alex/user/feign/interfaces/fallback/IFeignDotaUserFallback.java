package com.alex.user.feign.interfaces.fallback;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.vo.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * IFeignDotaUser 降级接口
 */
@Slf4j
@Component
public class IFeignDotaUserFallback implements IFeignDotaUser{
    @Override
    public RJson<UserVo> loginByWechatToken(String token) {
        return RJson.ok(new UserVo().setUserNo(1l)).setMsg("IFeignDotaUserFallback");
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
        log.warn("getByUserNo 出发熔断");
        return RJson.failed("熔断", 202);
    }

    @Override
    public RJson<UserVo> getByMobile(String mobile) {
        return null;
    }
}
