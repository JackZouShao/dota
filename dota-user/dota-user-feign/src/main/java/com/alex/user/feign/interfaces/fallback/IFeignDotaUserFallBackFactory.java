package com.alex.user.feign.interfaces.fallback;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.vo.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IFeignDotaUserFallBackFactory implements FallbackFactory<IFeignDotaUser> {
    @Override
    public IFeignDotaUser create(Throwable throwable) {
        return new IFeignDotaUser() {
            @Override
            public RJson<UserVo> loginByWechatToken(String token) {
                return RJson.failed("FallbackFactory");
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
        };
    }
}
