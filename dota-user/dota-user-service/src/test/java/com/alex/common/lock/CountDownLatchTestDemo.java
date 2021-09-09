package com.alex.common.lock;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @className CountDownLatchTestDemo.java
 * @author: yz
 * @date: 2021/9/8 16:18
 */
public class CountDownLatchTestDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(new QueueTask(countDownLatch)).start();
        new Thread(new Runner(countDownLatch)).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("执行完毕");
    }

}

@RequiredArgsConstructor
class QueueTask implements Runnable{

    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        try {
            System.out.println("排队。。。。。");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("排队结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}

@RequiredArgsConstructor
class Runner implements Runnable{

    private final CountDownLatch countDownLatch;

    @Override
    public void run() {
        try {
            System.out.println("买药。。。。。");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("买药结束。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }
}