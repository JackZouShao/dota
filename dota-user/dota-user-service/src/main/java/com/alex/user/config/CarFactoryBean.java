package com.alex.user.config;

import com.alex.user.jojo.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * @version 1.0.0
 * @className CarFactoryBean.java
 * @author: yz
 * @date: 2021/6/6 20:22
 */
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
