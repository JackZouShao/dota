package com.alex.user.feign.interfaces.fallback;

import com.alex.common.util.R;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.interfaces.vo.qo.UserQO;
import com.alex.user.feign.interfaces.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * IFeignDotaUser 降级接口
 */
@Slf4j
@Component
public class IFeignDotaUserFallback implements IFeignDotaUser{
    @Override
    public R<UserVo> loginByWechatToken(String token) {
        return R.ok(new UserVo().setUserNo(1L)).setMsg("IFeignDotaUserFallback");
    }

    @Override
    public R<UserVo> loginBySteamToken(String token) {
        return null;
    }

    @Override
    public R<UserVo> updateById(UserQO qo) {
        return null;
    }

    @Override
    public R<String> deleteById(Long id) {
        return null;
    }

    @Override
    public R<UserVo> getByUserNo(Long userNo) {
        log.warn("getByUserNo触发熔断");
        return R.ok(new UserVo(), "getByUserNo触发熔断");
    }

    @Override
    public R<UserVo> getByMobile(String mobile) {
        return null;
    }
}
