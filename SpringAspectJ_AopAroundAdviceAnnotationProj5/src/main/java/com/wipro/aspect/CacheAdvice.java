package com.wipro.aspect;

import java.util.Arrays;
import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Order(1)
@Component("cacheAdvice")
public class CacheAdvice {

	private HashMap<String ,Object> cache=new HashMap<>();
	@Around("execution(* com.wipro.service.*.*(..))")
	public Object caching(ProceedingJoinPoint pjp)throws Throwable
	{
		String key;
		key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		Object retVal;
		if(!cache.containsKey(key))
		{retVal =pjp.proceed();
		System.out.println("From taget method");
		return retVal;
		}
		else
		{
			System.out.println("From cached");
			return cache.get(key);
		}
	}
}
