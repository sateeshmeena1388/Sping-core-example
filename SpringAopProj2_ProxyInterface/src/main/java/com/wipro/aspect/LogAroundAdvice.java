package com.wipro.aspect;

import java.sql.Date;
import java.util.Arrays;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LogAroundAdvice implements MethodInterceptor {
private static Logger logger=null;
	
static {
	logger=Logger.getLogger(LogAroundAdvice.class);
	// TODO Auto-generated constructor stub
	PropertyConfigurator.configure("src/main/java/com/wipro/commons/log.properties");
}
@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
	Object retValue=null;
	Object[] args=null;
	 final String s="with args";
	
	logger.debug("Entering Into "+invocation.getMethod()
	.getName()+ s +Arrays.toString(invocation.
			getArguments())+ "at"+new Date(0));
		// TODO Auto-generated method stub
		//Modify aruments values
		args=invocation.getArguments();
		if(((Float)args[0])<50000)
		{
			args[2]=(Float)args[2]-0.50f;
		}
		
		if(((Float)args[0])==0||(Float)args[1]==0||(Float)args[2]==0)	
        {
logger.error("Invalid input while calling "+invocation.getMethod().getName()+" s "+Arrays.toString(invocation.getArguments()));
        	
        }
		else
		{
			retValue=invocation.proceed();
		}
			
		logger.debug("leaving from "+invocation.getMethod().getName()+" s "+Arrays.toString(invocation.getArguments()));
		//modify
		retValue=((Float)retValue)+(((Float)retValue)*0.18f);
		return retValue;
	}

}
