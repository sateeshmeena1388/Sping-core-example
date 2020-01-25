package com.wipro.aspect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
@Component("cache")
public class CacheAdvice implements MethodInterceptor {

	private Map<String,Object> cache=new HashMap<>();
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object retValue=null;
		String key=null;
		 key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
		
		if(!cache.containsKey(key))
		{
			retValue=invocation.proceed();
			cache.put(key, retValue);
			System.out.println("From target method");
			return retValue;
		}
		else{
			retValue=cache.get(key);
			System.out.println("from cache");
		}
		return retValue;
	}

}
