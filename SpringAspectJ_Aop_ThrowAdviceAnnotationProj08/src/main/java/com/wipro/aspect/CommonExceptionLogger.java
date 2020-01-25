package com.wipro.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component("cLogger")
public class CommonExceptionLogger {
@Pointcut("execution(* com.wipro.service.*.*(..))")
public void myPointcut(){}
	@AfterThrowing(value="myPointcut()",throwing="ae")
	public void exceptionLogger(JoinPoint jp,ArithmeticException ae)
	{
		System.out.println(ae.getClass()+"Exception"
				+ "raised With Msg"+ae.getMessage()+ 
				"in "+jp.getSignature()+" wit args"
				+Arrays.toString(jp.getArgs()));
		throw new IllegalArgumentException("provide valid inputs");
		
	}
}
