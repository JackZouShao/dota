package com.alex.gateway.config;

import com.alex.common.advice.CustomSentinelBlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * sentinel 配置
 * @version 1.0.0
 * @className GatewayConfiguration.java
 * @author: yz
 * @date: 2021/9/21 16:32
 */
//@Configuration
@RequiredArgsConstructor
public class GatewayConfiguration {

    private final List<ViewResolver> resolverList;

    private final ServerCodecConfigurer codecConfigurer;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler(){
        return new SentinelGatewayBlockExceptionHandler(resolverList, codecConfigurer);
    }

    @Bean
    @Order(-1)
    public GlobalFilter sentinelGlobalFilter(){
        return new SentinelGatewayFilter();
    }



    @PostConstruct
    public void doInit(){
        //初始化自定义的API
//        initCustomizedApis();
//        //初始化网关限流规则
//        initGatewayRules();
//        //自定义限流异常处理器
//        initBlockRequestHandler();
    }


    private void initBlockRequestHandler() {
        BlockRequestHandler blockRequestHandler = (exchange, t) -> {
            HashMap<String, String> result = new HashMap<>();
            result.put("code",String.valueOf(HttpStatus.TOO_MANY_REQUESTS.value()));
            result.put("msg", HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase());

            // 设置返回结果
            return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(result));
        };
        //设置自定义异常处理器
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }

    /**
     * 初始化自定义的API
     */
    private void initCustomizedApis(){
        Set<ApiDefinition> definitions = new HashSet<>();
        // 用户自定义的 API 分组名称
        ApiDefinition api = new ApiDefinition("dota-user-service")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {{
                    add(new ApiPathPredicateItem().setPattern("/feign/**")
                            .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
                }});
        definitions.add(api);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }

    /**
     * 初始化限流规则
     */
    private void initGatewayRules() {
        Set<GatewayFlowRule> rules = new HashSet<>();
        //resource：资源名称，可以是网关中的 route 名称或者用户自定义的 API 分组名称。
        //count：限流阈值
        //intervalSec：统计时间窗口，单位是秒，默认是 1 秒
        rules.add(new GatewayFlowRule("dota-user-service")
                .setCount(1)
                .setIntervalSec(1)
        );

        GatewayRuleManager.loadRules(rules);
    }
}
