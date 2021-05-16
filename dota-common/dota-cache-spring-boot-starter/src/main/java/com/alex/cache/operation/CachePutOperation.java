package com.alex.cache.operation;

import com.alex.cache.CacheUtils;
import com.alex.cache.annotation.CachePut;
import com.alex.cache.manager.AnnotationParam;
import com.alex.cache.manager.Cache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import java.lang.reflect.Method;

public class CachePutOperation implements CacheOperation {

	@Resource
	private Cache cache;

	@Override
	public Object cache(JoinPoint joinPoint) {

		ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable  throwable) {
			throwable.printStackTrace();
		}

		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = signature.getMethod();

		CachePut annotation = method.getAnnotation(CachePut.class);
		AnnotationParam param = getParam(annotation);
		String key = CacheUtils.parseSpel(method, joinPoint.getArgs(), param.getKey(), String.class, "");
		key = param.setCacheKey(key);

		cache.set(key, result, param.getExpireTime(), param.getTimeUnit());
		return result;
	}

	private AnnotationParam getParam(CachePut annotation){
		return AnnotationParam.builder()
				.prefix(annotation.prefix())
				.key(annotation.key())
				.expireTime(annotation.expireTime())
				.timeUnit(annotation.timeUnit())
				.dataType(annotation.cacheType())
				.hashKey(annotation.hashKey())
				.build();
	}
}
