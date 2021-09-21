package com.alex.user.feign.interfaces;

import com.alex.common.util.RJson;
import com.alex.user.feign.interfaces.fallback.IFeignDotaUserFallBackFactory;
import com.alex.user.feign.interfaces.fallback.IFeignDotaUserFallback;
import com.alex.user.feign.qo.UserQO;
import com.alex.user.feign.vo.UserVo;
import io.swagger.annotations.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * fallbackFactory = IFeignDotaUserFallBackFactory.class,
 *
 * user interface
 * for basic function
 */
@Api(tags = "用户模块FeignApi")
@FeignClient(value = "dota-user-service", fallback = IFeignDotaUserFallback.class)
public interface IFeignDotaUser {

    @ApiOperation(value = "根据WeChatToken当前登录用户")
    @ApiImplicitParam(value = "wechat token" ,name = "token", required = true , example = "123", paramType = "body")
    @RequestMapping(value = "/feign/user/loginByWeChatToken",  method = RequestMethod.POST)
    RJson<UserVo> loginByWechatToken(@RequestBody String token);

    @ApiOperation(value = "根据SteamToken当前登录用户")
    @RequestMapping(value = "/feign/user/loginBySteamToken", method = RequestMethod.POST)
    RJson<UserVo> loginBySteamToken(@RequestBody String token);

    @ApiOperation(value = "更新用户")
    @RequestMapping(value = "/feign/user/user/update", method = RequestMethod.PUT)
    RJson<UserVo> updateById(@RequestBody UserQO qo);

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/feign/user/user/delete/{id}", method = RequestMethod.DELETE)
    RJson<String> deleteById(@PathVariable(value = "id") Long id);

    @ApiOperation(value = "根据用户编号获取当前登录用户", response = UserVo.class)
    @RequestMapping(value = "/feign/user/user/getByUserNo/{userNo}", method = RequestMethod.GET)
    RJson<UserVo> getByUserNo(@PathVariable(value = "userNo") Long userNo);

    @ApiOperation(value = "根据手机号码获取登录用户" )
    @RequestMapping(value = "/feign/user/user/getByMobile/{mobile}", method = RequestMethod.GET)
    RJson<UserVo> getByMobile(@PathVariable(value = "mobile") String mobile);

}
