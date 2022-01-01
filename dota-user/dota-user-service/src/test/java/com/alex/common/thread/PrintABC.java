package com.alex.common.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @className PrintABC.java
 * @author: yz
 * @date: 2021/11/3 19:28
 */
public class PrintABC {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        Condition condition = reentrantLock.newCondition();
        new Thread(new PrintA(i, reentrantLock, condition), "A").start();
        new Thread(new PrintB(i, reentrantLock, condition), "B").start();
        new Thread(new PrintC(i, reentrantLock, condition), "C").start();
    }

}


class PrintA implements Runnable{

    private int i ;
    private ReentrantLock lock;
    private Condition condition;

    public PrintA(int i, ReentrantLock lock, Condition condition) {
        this.i = i;
        this.lock = lock;
        this.condition = condition;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            lock.lock();
            condition.signal();
//            while (i % 3 == 1){
//                condition.signal();
//
//                System.out.println("A");
//                condition.await();
//            }
//            i++;
            System.out.println(Thread.currentThread().getName());
        }
    }
}
class PrintB implements Runnable{

    private int i ;
    private ReentrantLock lock;
    private Condition condition;

    public PrintB(int i, ReentrantLock lock, Condition condition) {
        this.i = i;
        this.lock = lock;
        this.condition = condition;
    }
    @SneakyThrows
    @Override
    public void run() {
        while (true){
            lock.lock();
            condition.signal();
//            while (i % 3 == 2){
//                condition.signal();
//                System.out.println("B");
//                condition.await();
//            }
//            i++;
            System.out.println(Thread.currentThread().getName());
            condition.await();
            lock.unlock();
        }
    }
}
class PrintC implements Runnable{

    private int i ;
    private ReentrantLock lock;
    private Condition condition;

    public PrintC(int i, ReentrantLock lock, Condition condition) {
        this.i = i;
        this.lock = lock;
        this.condition = condition;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            lock.lock();
//            while (i % 3 == 0){
//                condition.signal();
//                System.out.println("C");
//                condition.await();
//            }
//            i++;
            condition.signal();
            System.out.println(Thread.currentThread().getName());
            condition.await();
            lock.unlock();
        }
    }
}
