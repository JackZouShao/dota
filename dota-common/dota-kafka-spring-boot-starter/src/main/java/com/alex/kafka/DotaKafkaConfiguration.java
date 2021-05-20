package com.alex.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @version 1.0.0
 * @className DotaKafkaConfiguration.java
 * @author: yz
 * @date: 2021/5/20 19:16
 */
@EnableConfigurationProperties({KafkaProperties.class})
public class DotaKafkaConfiguration {

    @Bean
    @ConditionalOnProperty("spring.kafka")
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<String, String>(new DefaultKafkaProducerFactory<>());
    }


}
