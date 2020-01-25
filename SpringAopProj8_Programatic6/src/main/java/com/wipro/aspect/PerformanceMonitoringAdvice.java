package com.wipro.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {
long start;
long end;
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		start=System.currentTimeMillis();
		Object retval=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+ 
		"with args" +Arrays.toString(invocation.getArguments())+" has taken" +(end-start)+ "ms");
		
		return retval;
	}

}
