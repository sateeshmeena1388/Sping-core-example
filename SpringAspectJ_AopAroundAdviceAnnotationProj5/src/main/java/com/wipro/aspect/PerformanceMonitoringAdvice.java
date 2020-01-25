package com.wipro.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Order(3)
@Component("pAdvice")
public class PerformanceMonitoringAdvice {
long start;long end;
@Around("execution(* com.wipro.service.*.*(..))")
public Object pMonitoring(ProceedingJoinPoint pjp)throws Throwable
{
	start=System.currentTimeMillis();
	Object retval=pjp.proceed();
	end=System.currentTimeMillis();
	System.out.println(pjp.getSignature()+" with args"+Arrays.toString(pjp.getArgs())+" has taken"+(end-start)+ "ms");
	return retval;
}
}
