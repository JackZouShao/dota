package com.alex.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0
 * @className TypeVariableDemo.java
 * @author: yz
 * @date: 2021/5/27 12:28
 */
public class TypeVariableDemo {

    public static void main(String[] args) {
        getTypeVariable();
    }

    public static void getTypeVariable(){
        Class<Supper> superClass = Supper.class;
        TypeVariable<Class<Supper>>[] typeParameters = superClass.getTypeParameters();
        for (TypeVariable<Class<Supper>> typeVariable : typeParameters) {
            System.out.println("getBounds --> " + Arrays.toString(typeVariable.getBounds()));
            // 获取声明这个类型变量实体的名称
            System.out.println("getGenericDeclaration --> " + typeVariable.getGenericDeclaration());
            System.out.println("getName --> " + typeVariable.getName()); // 获取名称 K V E 类型
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();

            StringBuilder stringBuilder = new StringBuilder();
            for (AnnotatedType annotatedBound : annotatedBounds) {
                Annotation[] annotations = annotatedBound.getAnnotations();
                for (Annotation annotation : annotations) {
                    stringBuilder.append(annotation).append(",");
                }
            }
            System.out.println(stringBuilder.toString());
            System.out.println("=======");
        }
    }
}
