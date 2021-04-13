package com.alex.common.relect;

import com.alex.common.exceptions.BusinessException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws IllegalAccessException {
        Class clazz = BusinessException.class;
        BusinessException businessException = new BusinessException("1");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Class<?> type = declaredField.getType();
            if (type == String.class) {
                String field = (String) declaredField.get(businessException);
                System.out.println(field);
            }
            if(type == Integer.class){
                System.out.println("Integer");
            }
            if(type == int.class ){
                System.out.println(int.class);
            }
        }
    }

    public void t1(List<BusinessException> list){
        list.stream().forEach(e ->{

        });


    }
}

class Main {
    public static void main(String[] args) {
        InvocationHandler handler = (proxy, method, args1) -> {
            System.out.println(method);
            if (method.getName().equals("morning")) {
                System.out.println("Good morning, " + args1[0]);
            }
            return null;
        };
        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}

interface Hello {
    void morning(String name);
}
