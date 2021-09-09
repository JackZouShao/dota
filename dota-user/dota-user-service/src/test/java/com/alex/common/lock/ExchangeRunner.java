package com.alex.common.lock;

import java.util.concurrent.Exchanger;

/**
 * Exchange
 * 当一个线程运行到exchange()方法时会阻塞，另一个线程运行到exchange()时，二者交换数据，然后执行后面的程序
 * @version 1.0.0
 * @className ExchangeRunner.java
 * @author: yz
 * @date: 2021/9/8 16:37
 */
public class ExchangeRunner {

    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();
        for (int i = 0; i < 10; i++) {
            final Integer num = i;
            new Thread(()->{
                System.out.println("I am " + Thread.currentThread().getName() +"; And data is " + num);
                try {
                    Integer integerAfter = exchanger.exchange(num);
                    Thread.sleep(1000);
                    System.out.println("我是线程：Thread_" + Thread.currentThread().getName() + "我原先的数据为：" + num + " , 交换后的数据为：" + integerAfter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
