package com.alex.common;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0.0
 * @className com.alex.common.WildcardTypeDemo.java
 * @author: yz
 * @date: 2021/5/27 12:42
 */
public class WildcardTypeDemo {
    public static void main(String[] args) {
        Class<WildcardTypeDemo> wildcardTypeDemoClass = WildcardTypeDemo.class;
        Method[] methods = wildcardTypeDemoClass.getMethods();
        for (Method method : methods) {
            if ("print".equals(method.getName())) {
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                for (Type type : genericParameterTypes) {
                    if(type instanceof ParameterizedType){
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        for (Type actualType : actualTypeArguments) {
                            if(actualType instanceof WildcardType){
                                WildcardType wildcardType = (WildcardType) actualType;
                                System.out.println("WildcardType --> " + wildcardType + "getUpperBounds --> "
                                        + Arrays.toString(wildcardType.getUpperBounds()));
                                System.out.println("WildcardType --> " + wildcardType + "getLowerBounds --> "
                                        + Arrays.toString(wildcardType.getLowerBounds()));
                            }else {
                                System.out.println("No WildcardType --> " + actualType);
                            }
                        }
                    }
                }
            }
        }
    }

    interface Person{}

    public static void print(List<? extends  Number> list, Set<? extends Person> persons){

    }
}
