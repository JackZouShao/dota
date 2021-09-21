package com.alex.user.feign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @className Person.java
 * @author: yz
 * @date: 2021/5/15 16:18
 */
@Data
@AllArgsConstructor
public class Person{
    private String name;
    private int age;
}
