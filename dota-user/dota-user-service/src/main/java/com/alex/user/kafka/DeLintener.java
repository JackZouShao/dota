                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        package com.alex.user.kafka;

import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Comparator;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        /**
 * @version 1.0.0
 * @className DeLintener.java
 * @author: yz
 * @date: 2021/5/23 15:14
 */
public class DeLintener implements Comparable<DeLintener> {
    private double age;
    private int price;



    private static final Comparator<DeLintener> COMPARATOR =
            Comparator.comparingDouble((DeLintener line) ->  line.age)
            .thenComparing((DeLintener line) -> line.age);


    @Override
    public int compareTo(@NotNull DeLintener o) {
        return COMPARATOR.compare(this, o);
    }


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            //    @KafkaListener(topics = "demo", groupId = "group1")
//    public void onLoginMessage(@Payload String message, @Header("type") String type) throws Exception {
//        System.out.println(message);
//        "1".hashCode();
//    }
}
