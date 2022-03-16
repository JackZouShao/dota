package com.alex.user.controller;

import com.alex.common.util.R;
import com.alex.user.feign.interfaces.IFeignDotaUser;
import com.alex.user.feign.interfaces.vo.qo.UserQO;
import com.alex.user.feign.interfaces.vo.UserVo;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务
 */


@Slf4j
@RestController
@RequiredArgsConstructor
public class DotaUserController implements IFeignDotaUser{

    private final RedissonClient redissonClient;

    @Override
    public R<UserVo> loginByWechatToken(String token) {
        return R.ok(new UserVo().setWechatToken("123"));
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
    private static final String RESOURCE_NAME = "hello";

    @Override
    public R<UserVo> getByUserNo(Long userNo) {
        log.info("查询 user info");
        Entry entry = null;
        int i = 1/0;
        return R.ok(new UserVo().setUserNo(123l));
    }

    @Override
    public R<UserVo> getByMobile(String mobile) {
        return null;
    }

    /**
     * 定义流控规则
     */
    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的资源阈值
        // Set limit QPS to 20.
        rule.setCount(1);
        rules.add(rule);
        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }
}
