package com.alex.common.thread;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @version 1.0.0
 * @className ThreadPoolRunner.java
 * @author: yz
 * @date: 2021/9/10 10:10
 */
@RunWith(JUnit4.class)
public class ThreadPoolRunner {

    @Test
    public void testThreadPool(){
        System.out.println(-1<< 2);

        TimeUnit unit;
        BlockingQueue workQueue;

        ThreadPoolExecutor t = new ThreadPoolExecutor(10, 20, 2, TimeUnit.SECONDS, null);

        t.execute(null);
        retry:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                break retry;
            }
        }

    }
}
