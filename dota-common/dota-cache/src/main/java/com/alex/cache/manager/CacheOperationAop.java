package com.alex.cache.manager;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @version 1.0.0
 * @className CacheOperationAop.java
 * @author: yz
 * @date: 2021/5/13 20:03
 */
@Aspect
@RequiredArgsConstructor
public class CacheOperationAop {

    private final CacheOperation cacheGetOperation;
    private final CacheOperation cacheInvalidateOperation;

    @Pointcut("@annotation(com.alex.cache.annotation.CacheUpdate)")
    public void cacheUpdate(){

    }

    @Pointcut("@annotation(com.alex.cache.annotation.CacheInvalidate)")
    public void cacheInvalidate(){

    }

    @Pointcut("@annotation(com.alex.cache.annotation.CacheGet)")
    public void cacheGet(){

    }

    @Pointcut("@annotation(com.alex.cache.annotation.CacheGetAndPut)")
    public void cacheGetAndPut(){

    }

    @After(value = "cacheUpdate()")
    public Object doCacheUpdate(JoinPoint joinPoint){
        return null;
    }

    @Before(value = "cacheInvalidate()")
    public Object doCacheInvalidate(JoinPoint joinPoint){
        return null;
    }

    @Before(value = "cacheGet()")
    public Object doCacheGet(JoinPoint joinPoint){
        return null;
    }

    @Around(value = "cacheGetAndPut()")
    public Object doCacheGetAndPut(JoinPoint joinPoint){
        return null;
    }

}
