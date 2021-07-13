package com.alex.user.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @version 1.0.0
 * @className CarBeanPostProcessor.java
 * @author: yz
 * @date: 2021/6/6 20:23
 */
@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("TestBeanPostProcessor...postProcessBeforeInitialization ---> "+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("TestBeanPostProcessor...postProcessAfterInitialization ---> "+beanName);
        return bean;
    }
}
