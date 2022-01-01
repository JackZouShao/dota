package com.alex.common;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @version 1.0.0
 * @className Algorithm.java
 * @author: yz
 * @date: 2021/10/22 09:19
 */
public class Algorithm {

    static Thread add;
    static Thread even;
    private static volatile  Algorithm algorithm;
    public static void main(String[] args) throws InterruptedException {

        MyPrint print = new MyPrint();
        Thread thread1 = new Thread(print,"A");
        Thread thread2 = new Thread(print,"B");
        Thread thread3 = new Thread(print,"C");
        thread1.start();
        thread2.start();
        thread3.start();

//         add = new Thread(() ->{
//            for (int i = 1; i < 100; i++) {
//                if((i % 2) == 1){
//                    LockSupport.unpark(even);
//                    System.out.println(Thread.currentThread().getName() + " - " + i);
//                    LockSupport.park();
//                }
//            }
//        });
//
//         even = new Thread(() ->{
//            for (int i = 2; i <=100; i++) {
//                if((i % 2) == 0){
//                    LockSupport.park();
//                    System.out.println(Thread.currentThread().getName() + " - "  + i);
//                    LockSupport.unpark(add);
//                }
//            }
//        });
//        add.start();
//        even.start();
    }

    public static Algorithm getSingleton(){
        if (algorithm == null) {
            synchronized (Algorithm.class){
                if(algorithm == null){
                    algorithm = new Algorithm();
                }
            }
        }
        return algorithm;
    }



}

class MyPrint implements Runnable{
    int i = 1;

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if( i > 100){
                    return;
                }
                this.notify();

                System.out.println(Thread.currentThread().getName() +"-"+ i++);
                this.wait();
            }
        }
    }
}
