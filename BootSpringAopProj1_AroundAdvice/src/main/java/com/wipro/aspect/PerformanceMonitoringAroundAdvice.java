package com.wipro.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
@Component("pmAdvice")
public class PerformanceMonitoringAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		 long start=0;
		 long end=0;
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println("PmAroundAdvice" +invocation.getMethod().getName()+" with args"
				+Arrays.toString(invocation.getArguments())+"has taken"+(end-start)+ "ms");
		return retVal;
	}

	
}
