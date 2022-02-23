package com.alex.user.feign.interfaces.fallback;

import com.alex.common.util.R;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.interfaces.vo.qo.UserQO;
import com.alex.user.feign.interfaces.vo.UserVo;
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
            public R<UserVo> loginByWechatToken(String token) {
                return R.failed("FallbackFactory");
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
                log.error("error getByUserNo");
                return R.failed("getuserinfo  失败测试");
            }

            @Override
            public R<UserVo> getByMobile(String mobile) {
                return null;
            }
        };
    }
}
