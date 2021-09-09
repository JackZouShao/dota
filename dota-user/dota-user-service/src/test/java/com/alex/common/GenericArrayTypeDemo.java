package com.alex.common;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @version 1.0.0
 * @className GenericArrayTypeDemo.java
 * @author: yz
 * @date: 2021/5/27 18:31
 */
public class GenericArrayTypeDemo {

    public static void main(String[] args) {
        Class<GenericArrayTypeDemo> genericArrayTypeDemoClass = GenericArrayTypeDemo.class;
        Method[] methods = genericArrayTypeDemoClass.getMethods();
        for (Method method : methods) {
            if("method".equals(method.getName())){
                // 先要获取 <>里的泛型
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                for (Type type : genericParameterTypes) {
                    if(type instanceof GenericArrayType){
                        GenericArrayType genericArrayType = (GenericArrayType) type;
                        System.out.println("GenericArrayType --> " + type + " getGenericComponentType --> "
                        + genericArrayType.getGenericComponentType());
                        System.out.println(genericArrayType.getTypeName());
                    }
                }
            }
        }
    }

    public static <T> void method(String[] strings, List<String> ls, List<String> [] lsa, T[] ts, List<T>[] ta, T[][] tts){

    }
}
