package com.wipro.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {

	public void exceptionLogger(JoinPoint jp,ArithmeticException ae)
	{
		System.out.println(ae.getClass()+"Exception"
				+ "raised With Msg"+ae.getMessage()+ 
				"in "+jp.getSignature()+" wit args"
				+Arrays.toString(jp.getArgs()));
		throw new IllegalArgumentException("provide valid inputs");
		
	}
}
