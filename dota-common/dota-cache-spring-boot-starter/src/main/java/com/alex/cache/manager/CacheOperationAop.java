package com.alex.cache.manager;

import com.alex.cache.operation.CacheOperation;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    private final CacheOperation cachePutOperation;
    private final CacheOperation cacheInvalidateOperation;
    private final CacheOperation cacheGetOperation;

    @Pointcut("@annotation(com.alex.cache.annotation.CachePut)")
    public void cachePut(){

    }

    @Pointcut("@annotation(com.alex.cache.annotation.CacheInvalidate)")
    public void cacheInvalidate(){

    }

    @Pointcut("@annotation(com.alex.cache.annotation.CacheGet)")
    public void cacheGet(){

    }

    @After(value = "cacheInvalidate()")
    public Object doCacheInvalidate(JoinPoint joinPoint){
        return cacheInvalidateOperation.cache(joinPoint);
    }

    @AfterReturning(value = "cachePut()")
    public Object doCachePut(JoinPoint joinPoint){
        return cachePutOperation.cache(joinPoint);
    }

    @Around(value = "cacheGet()")
    public Object doCacheGet(ProceedingJoinPoint joinPoint){
        return cacheGetOperation.cache(joinPoint);
    }

}
