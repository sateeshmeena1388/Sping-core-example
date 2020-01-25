package com.wipro.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component("logAdvice")
public class LoggingAdvice {

	@Pointcut("execution(* com.wipro.service.*.*(..))")
	public void muPointcut()
	{}
	
	@Around("muPointcut()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("Entering into" +pjp.getSignature());
		Object retVal=pjp.proceed();
		System.out.println("Leaving from "+pjp.getSignature());
		return retVal;
	}
	
	@Before("muPointcut()")
	public void checkInput(JoinPoint jp)
	{
		Object args[]=jp.getArgs();
		if((Integer)args[0]<=0||(Integer)args[1]<=0)
		{
			throw new IllegalArgumentException("Provided proper input");
		}
	}
	@AfterReturning(value="muPointcut()", returning="result")
	public void checkResult(JoinPoint jp,int result)
	{
		if(result<=0)
		{
			throw new IllegalArgumentException("Invalid result");
	    }
}
	@AfterThrowing(value="muPointcut()", throwing="e")
	public void exeptionLogger(JoinPoint jp,Exception e)
	{
		System.out.println(jp.getSignature()+" has raised" +e.getClass()+" Exception");
	
	}

}
