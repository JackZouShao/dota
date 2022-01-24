package config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 配置Feign日志级别
 * @version 1.0.0
 * @className FeignConfig.java
 * @author: yz
 * @date: 2022/1/22 16:48
 */
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
