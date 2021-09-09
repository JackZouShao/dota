package com.alex.common.lock;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

/**
 * @version 1.0.0
 * @className SemaphoreTestDemo.java
 * @author: yz
 * @date: 2021/9/8 16:04
 */
public class SemaphoreTestDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2, true);
        for (int i = 0; i < 5; i++) {
            Task task = new Task(semaphore);
            task.start();
        }

    }
}

@RequiredArgsConstructor
class Task extends Thread{

    private final Semaphore semaphore;

    @Override
    public void run() {
        try {
            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() + " acquire() at time : " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            Thread.sleep(5000);

            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " release() at time : " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
