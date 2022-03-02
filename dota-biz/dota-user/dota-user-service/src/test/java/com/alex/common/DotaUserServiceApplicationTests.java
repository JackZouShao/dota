package com.alex.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class DotaUserServiceApplicationTests {

    @Test
    void contextLoads() {
        ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(()-> new SimpleDateFormat());
        DateFormat dateFormat = threadLocal.get();
    }


    @FunctionalInterface
    interface Op{
        void test();
    }

    public static void main(String[] args) {

        ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(()-> new SimpleDateFormat());
        DateFormat dateFormat = threadLocal.get();
        System.out.println(dateFormat);
    }
}
