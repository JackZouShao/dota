package com.alex.order.service;

import com.alex.cache.annotation.CacheGet;
import com.alex.user.feign.vo.Person;
import org.springframework.stereotype.Service;

@Service
public class DemoService {


//	@CachePut(prefix = "p:s", key = "")
	@CacheGet(prefix = "p:s", key = "")
//	@CacheInvalidate(prefix = "p:s", key = "")
	public Person getPerson(){
		return new Person("123", 1322222222);
	}
}
