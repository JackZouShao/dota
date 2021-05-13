package com.alex.cache.manager;

import org.aspectj.lang.JoinPoint;

/**
 * @version 1.0.0
 * @className CaceOperation.java
 * @author: yz
 * @date: 2021/5/13 20:07
 */
@FunctionalInterface
public interface CacheOperation {


    Object cache(JoinPoint joinPoint);


}
