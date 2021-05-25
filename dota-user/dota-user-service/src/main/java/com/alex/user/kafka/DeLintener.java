package com.alex.user.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @version 1.0.0
 * @className DeLintener.java
 * @author: yz
 * @date: 2021/5/23 15:14
 */
public class DeLintener {
    @KafkaListener(topics = "demo", groupId = "group1")
    public void onLoginMessage(@Payload String message, @Header("type") String type) throws Exception {
        System.out.println(message);
    }

}
