package com.alex.common.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @version 1.0.0
 * @className ScheduleExecutorTestRunner.java
 * @author: yz
 * @date: 2021/9/12 15:46
 */
@RunWith(JUnit4.class)
public class ScheduleExecutorTestRunner {


    @Test
    public void TestA(){
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(12);
//        scheduledThreadPoolExecutor.scheduleAtFixedRate();
//        scheduledThreadPoolExecutor.schedule();
//        scheduledThreadPoolExecutor.scheduleWithFixedDelay();
    }
}
