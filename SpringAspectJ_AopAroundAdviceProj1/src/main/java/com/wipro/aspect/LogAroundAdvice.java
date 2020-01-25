package com.wipro.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAroundAdvice {
public Object logging(ProceedingJoinPoint pjp) throws Throwable
{
	System.out.println("Entering into"+pjp.getSignature()+ "with args" +Arrays.toString(pjp.getArgs()));
	//get args and modify
	Object args[]=pjp.getArgs();
	if((Float)args[0]<50000)
	{
		args[2]=(Float) args[2]-1;
		
	}
	Object retVal=null;
	if((Float)args[0]==0||(Float)args[1]==0||(Float)args[2]==0)
		throw new IllegalArgumentException("Provide +ve  and p t r values");
	else
		retVal=pjp.proceed(args);
	//add Service tax on intr amt
	retVal=(Float)retVal+(Float)retVal*0.05f;
	System.out.println("Exiting from "+pjp.getSignature()+" with args"+ Arrays.toString(pjp.getArgs()));

return retVal;
}
}
