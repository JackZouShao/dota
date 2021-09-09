package com.alex.common.lock;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0.0
 * @className CyclicBarrierRunner.java
 * @author: yz
 * @date: 2021/9/8 16:29
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class CyclicBarrierRunner implements Runnable{

    private final CyclicBarrier cyclicBarrier;

    private int index;


    @Override
    public void run() {
        try {
            System.out.println("index : " + index);
            index--;
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, () ->{
            System.out.println(" 执行屏障任务");
        });
        for (int i = 0; i < 10; i++) {
            new Thread(new CyclicBarrierRunner(cyclicBarrier, i)).start();
        }
        cyclicBarrier.await();
        System.out.println("全部到达屏障");

    }
}
