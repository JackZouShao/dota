package com.alex.dotaeureka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.*;
import java.util.Arrays;

@SpringBootTest
class DotaEurekaApplicationTests {

    @Test
    void contextLoads() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class clazz = DotaEurekaApplication.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getPackage());
        Arrays.stream(clazz.getDeclaredFields()).peek(System.out::println);
        Field field = clazz.getField("1");
        int modifiers = field.getModifiers();
        Modifier.isFinal(modifiers);
        Modifier.isSynchronized(modifiers);
        field.setAccessible(true);
        field.set(new DotaEurekaApplication(), "1");

        Method get = clazz.getDeclaredMethod("get", String.class);
        get.setAccessible(true);
        get.invoke(new DotaEurekaApplication(), 12); // 静态方法第一个参数null

        Constructor constructor = clazz.getConstructor(null); // 和父类无关
        DotaEurekaApplication o = (DotaEurekaApplication)constructor.newInstance();


    }

    public static final transient String str = "";

}

class Main {
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student());
        System.out.println(Integer.SIZE - 3);;
        System.out.println(String.class.getClassLoader());
    }
}

class Person {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student extends Person {
    public void hello() {
        System.out.println("Student:hello");
    }
}
class Teacher extends Person{
    @Override
    public void hello() {
        System.out.println("Teacher hello");
    }
}
