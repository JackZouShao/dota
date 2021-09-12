package com.alex.common.lock;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 让主线程等待其他线程执行后在执行
 * @version 1.0.0
 * @className ThreadJoinTestRunner.java
 * @author: yz
 * @date: 2021/9/12 10:40
 */
@RunWith(JUnit4.class)
public class ThreadJoinTestRunner {

    /**
     * 主线程等待其他线程完成
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            DemoThread demoThread = new DemoThread();
            Thread thread = new Thread(demoThread);
            thread.start();
            // 调用这段指令的线程等待thread线程执行完毕 再执行
            thread.join();
        }
        System.out.println("main thread terminated");
    }

    @Test
    public void testTwo() throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            new Thread(new LatchTread(countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("main thread terminated");

    }

    @Test
    public void testReentrantLock() throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);
        for (int i = 0; i < 4; i++) {
            new Thread(new ReentrantLockThread(lock)).start();
        }
        TimeUnit.MILLISECONDS.sleep(500);
        lock.lock();
        lock.unlock();
        System.out.println("main thread terminated");

    }

    /**
     * 使用Latch的Runnable类
     */
    private class LatchTread implements Runnable {

        private CountDownLatch countDownLatch;
        public LatchTread(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " : start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread() + " : end");
            countDownLatch.countDown();
        }

    }

    /**
     * Reentre
     */
    @RequiredArgsConstructor
    private class ReentrantLockThread implements Runnable{

        private final ReentrantLock lock;

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " : start");
            lock.lock();
            TimeUnit.SECONDS.sleep(5);
            lock.unlock();
            System.out.println(Thread.currentThread() + " : end");
        }
    }

    /**
     * 睡眠Runnable类
     */
    private class DemoThread implements Runnable{

        @SneakyThrows
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " : start");
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread() + " : end");

        }
    }
}
