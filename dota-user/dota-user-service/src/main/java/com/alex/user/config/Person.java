package com.alex.user.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @className Person.java
 * @author: yz
 * @date: 2021/6/6 20:10
 */
@Component
public class Person implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("Person DisposableBean的destroy()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person InitializingBean的 afterPropertiesSet方法");
    }
}
