package com.wipro.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerfomanceMonitoringAdvice implements MethodInterceptor {
long start;
long end;
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		start=System.currentTimeMillis();
		Object retValue=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+" has taken "+(end-start)+" ms to Complete execution");
		
		return retValue;
	}

}
