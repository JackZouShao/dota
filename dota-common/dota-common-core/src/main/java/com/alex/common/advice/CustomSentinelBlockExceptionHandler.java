package com.alex.common.advice;

import com.alex.common.util.RJson;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义BlockExceptionHandler 的实现类统一处理BlockException
 * @version 1.0.0
 * @className SentinelBlockException.java
 * @author: yz
 * @date: 2022/1/23 01:24
 */
@Slf4j
public class CustomSentinelBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        log.info("BlockExceptionHandler BlockException================"+e.getRule());
        RJson r = null;
        if (e instanceof FlowException) {
            r = RJson.error(100,"接口限流了");

        } else if (e instanceof DegradeException) {
            r = RJson.error(101,"服务降级了");

        } else if (e instanceof ParamFlowException) {
            r = RJson.error(102,"热点参数限流了");

        } else if (e instanceof SystemBlockException) {
            r = RJson.error(103,"触发系统保护规则了");

        } else if (e instanceof AuthorityException) {
            r = RJson.error(104,"授权规则不通过");
        }

        //返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(), r);
    }
}
