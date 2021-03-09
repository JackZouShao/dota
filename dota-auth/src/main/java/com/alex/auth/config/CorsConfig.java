package com.alex.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {

    private static final String ALL = "*";

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public CorsWebFilter corsWebFilter(){

        CorsConfiguration config = new CorsConfiguration();

        // cookie 跨域
        config.setAllowCredentials(Boolean.TRUE);
        config.addAllowedOrigin(ALL);
        config.addAllowedHeader(ALL);
        config.addAllowedMethod(ALL);

        // 设置前端允许访问的自定义的header
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
