package com.alex.common.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.*;

/**
 * @version 1.0.0
 * @className CallableRunnerTest.java
 * @author: yz
 * @date: 2021/9/13 16:45
 */
@RunWith(JUnit4.class)
public class CallableRunnerTest {

    @Test
    public void testCaller() throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(1,2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        Future<String> submit = executorService.submit(new CallableThread());
        // 这一步会阻塞
        String s = submit.get();
        System.out.println(s);

    }

    private class CallableThread implements Callable<String>{

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(5);
            return "compute success";
        }
    }
}
