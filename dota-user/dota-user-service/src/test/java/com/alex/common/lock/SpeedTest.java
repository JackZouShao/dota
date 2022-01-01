package com.alex.common.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @className SpeedTest.java
 * @author: yz
 * @date: 2021/10/20 23:09
 */
@RunWith(JUnit4.class)
public class SpeedTest {

    @Test
    public void test(){
        Instant now = Instant.now();

        for (int i = 0; i < 10000; i++) {
            synchronized (SpeedTest.class){




            }
        }

        Instant now1 = Instant.now();

        System.out.println(Duration.between(now, now1).getNano());
    }
    @Test
    public void test1(){
        Instant now = Instant.now();
        ReentrantLock lock = new ReentrantLock(true);
        for (int i = 0; i < 10000; i++) {
           lock.lock();
           lock.unlock();
        }

        Instant now1 = Instant.now();

        System.out.println(Duration.between(now, now1).getNano());
    }

}
