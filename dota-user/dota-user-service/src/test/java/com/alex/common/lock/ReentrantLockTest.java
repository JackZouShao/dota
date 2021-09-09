package com.alex.common.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @className ReentrantLockTest.java
 * @author: yz
 * @date: 2021/8/31 20:02
 */
@RunWith(JUnit4.class)
public class ReentrantLockTest {

    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition condition = lock.newCondition();

    @Test
    public void test() throws InterruptedException {
        Runnable target = new ThreadO();
        Thread thread = new Thread(target);
        thread.start();

        Runnable target1 = new ThreadO();
        Thread thread1 = new Thread(target);
        thread1.start();

        TimeUnit.SECONDS.sleep(5);
        lock.lock();
        lock.tryLock(10, TimeUnit.SECONDS);
        lock.unlock();
//        System.out.println("get lock");
        condition.signal();
//        lock.unlock();

        thread.join();
    }


}

class ThreadO implements Runnable{

    @Override
    public void run() {
        ReentrantLockTest.lock.lock();
        try {
            System.out.println("sleep");
            ReentrantLockTest.condition.await();
            System.out.println("wake up");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReentrantLockTest.lock.unlock();
    }
}
