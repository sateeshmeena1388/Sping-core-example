package com.wipro.aspect;

import java.util.Arrays;
import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;

public class CacheAdvice {

	private HashMap<String ,Object> cache=new HashMap<>();
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
