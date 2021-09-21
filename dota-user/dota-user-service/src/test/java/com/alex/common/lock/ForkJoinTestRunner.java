package com.alex.common.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 * ForkJoin 测试
 * @version 1.0.0
 * @className ForkJoinTestRunner.java
 * @author: yz
 * @date: 2021/9/14 15:02
 */
@RunWith(JUnit4.class)
public class ForkJoinTestRunner {

    @Test
    public void testO() throws ExecutionException, InterruptedException {
        System.out.println(1<<30);
        int ncpu = Runtime.getRuntime().availableProcessors();
        long nps = (1000L * 1000 * 1000);
        long calcSum;
        boolean reportSteals = true;
        int[] array = Utils.buildRandomIntArray(20000000);
        System.out.println("cpu - num : " + ncpu);
        calcSum = seqSum(array);
        System.out.println("Seq sum = " + calcSum);
        LongSum ls = new LongSum(array, 0 ,array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        ForkJoinTask<Long> res = forkJoinPool.submit(ls);
        System.out.println("ForkJoin sum = " + res.get());

        forkJoinPool.shutdown();

        double pow = Math.pow(2, 3);
        System.out.println(pow);


    }
    static long seqSum(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; ++i)
            sum += array[i];
        return sum;
    }


    private class LongSum extends RecursiveTask<Long>{
        static final int SEQUENTIAL_THRESHOLD = 1000;
        static final long NPS = (1000L * 1000 * 1000);
        static final boolean extraWork = true; // change to add more than just a sum
        int low;
        int high;
        int[] array;
        LongSum(int[] arr, int lo, int hi) {
            array = arr;
            low = lo;
            high = hi;
        }
        @Override
        protected Long compute() {

            if(high -low <= SEQUENTIAL_THRESHOLD){
                long sum = 0;
                for (int i = low; i < high; i++) {
                    sum += array[i];
                }
                return sum;
            }else {
                int mid = low + (high - low) / 2;
                LongSum left = new LongSum(array, low, mid);
                LongSum right = new LongSum(array, mid, high);
                left.fork();
                right.fork();
                long rightAns = right.join();
                long leftAns = left.join();
                return leftAns + rightAns;
            }
        }
    }

    private static class Utils {

        public static int[] buildRandomIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = new Random().nextInt(100);
            }
            return array;
        }

        public static int[] buildRandomIntArray() {
            int size = new Random().nextInt(100);
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = new Random().nextInt(100);
            }
            return array;
        }

        public static void main(String[] args) {
            int[] ints = Utils.buildRandomIntArray(20);

            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i]);
            }
        }
    }
}
