package com.alex.common.spring;

import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @className ExceptionTest.java
 * @author: yz
 * @date: 2021/9/17 10:27
 */
@RunWith(JUnit4.class)
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(get());
    }

    static String get(){
        try {
            int i = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }finally {
            System.out.println("finally");
        }
        return "success;";

    }

    @Test
    public void deadLockTest() throws InterruptedException {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(new DeadThread(o1, o2)).start();
        synchronized (o2){
            TimeUnit.SECONDS.sleep(5);
            synchronized (o1){

            }
        }
    }

    private class DeadThread implements Runnable{

        private Object o1;
        private Object o2;

        public DeadThread(Object o1, Object o2 ){
            this.o1 = o1;
            this.o2 = o2;
        }

        @SneakyThrows
        @Override
        public void run() {
            synchronized (o1){
                TimeUnit.SECONDS.sleep(5);
                synchronized (o2){

                }
            }
        }
    }
}
