package com.alex.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0
 * @className RelectDemo.java
 * @author: yz
 * @date: 2021/5/26 10:43
 */
public class ReflectDemo {

    private List<String> list;

    public static void main(String[] args) throws NoSuchFieldException {



        Class<Sub> clazz = Sub.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        if(genericSuperclass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            System.out.println(parameterizedType.getRawType());
            System.out.println(parameterizedType.getOwnerType()); // Super.getDeclaringClass()
            System.out.println(parameterizedType.getTypeName());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            System.out.println("==");
            for (Type type : actualTypeArguments){
                System.out.println( type + "type is  parameterizedType " + (type instanceof ParameterizedType));
            }
        }

        Field field = ReflectDemo.class.getDeclaredField("list");
        Type genericType = field.getGenericType();

        System.out.println(genericType);
        System.out.println(genericType instanceof ParameterizedType);

    }


}

@Target(ElementType.FIELD)
@interface A{

}

interface Face{

}

class Supper<T extends Person & Face, E extends A>{

}

class Person{
    private String name;
    private List<Person> friends;
}
abstract class Super<T, E>{}

class Sub extends Super<String, List<Person>>{}