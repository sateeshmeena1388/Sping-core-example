package com.wipro.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAdvice {
long start;long end;
public Object pMonitoring(ProceedingJoinPoint pjp)throws Throwable
{
	start=System.currentTimeMillis();
	Object retval=pjp.proceed();
	end=System.currentTimeMillis();
	System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken"+(end-start)+ "ms");
	return retval;
}
}
