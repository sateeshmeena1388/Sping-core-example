package com.wipro.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Entering Into "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		// TODO Auto-generated method stub
		//Modify aruments values
		Object[] args=null;
		Object retValue=null;
	    args=invocation.getArguments();
		if(((Float)args[0])<50000)
		{
			args[2]=((Float)args[2])-0.5f;
		}
		
		if(((Float)args[0])==0||(Float)args[1]==0||(Float)args[2]==0)
        {
        throw new IllegalArgumentException("invalid inputs");
        }
		else
		{
			retValue=invocation.proceed();
		}
			System.out.println("leaving from "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		if(((Float)retValue)<=25000)
			return retValue;
		else
			return ((Float)retValue)+(((Float)retValue)*0.18f);
		
	}

}
