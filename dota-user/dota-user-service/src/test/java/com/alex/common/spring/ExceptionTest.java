package com.alex.common.spring;

/**
 * @version 1.0.0
 * @className ExceptionTest.java
 * @author: yz
 * @date: 2021/9/17 10:27
 */
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
        }
        return "success;";

    }
}
