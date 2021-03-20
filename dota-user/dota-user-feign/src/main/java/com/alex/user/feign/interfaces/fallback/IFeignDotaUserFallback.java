package com.alex.user.feign.interfaces.fallback;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IFeignDotaUser 降级接口
 */
@Component
@RequestMapping("/fallback")
public class IFeignDotaUserFallback implements IFeignDotaUser {
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
        return null;
    }

    @Override
    public RJson<UserVo> getByMobile(String mobile) {
        return null;
    }
}
