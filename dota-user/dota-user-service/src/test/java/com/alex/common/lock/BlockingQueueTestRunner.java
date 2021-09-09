package com.alex.common.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @version 1.0.0
 * @className BlockingQueueTestRunner.java
 * @author: yz
 * @date: 2021/9/9 09:49
 */
public class BlockingQueueTestRunner {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> numbersQueue = new ArrayBlockingQueue<>(16);
        numbersQueue.put(1);
        numbersQueue.take();
    }
}
