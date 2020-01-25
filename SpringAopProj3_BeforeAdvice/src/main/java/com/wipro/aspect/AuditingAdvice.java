package com.wipro.aspect;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.aop.MethodBeforeAdvice;

public class AuditingAdvice implements MethodBeforeAdvice {
private static Logger logger=null;
static{
	logger=Logger.getLogger(AuditingAdvice.class);
	PropertyConfigurator.configure("src/main/java/com/wipro/commons/log.properties");
}
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable 
	{
		// TODO Auto-generated method stub
		logger.debug("Target class name "+target.getClass());
		logger.debug("Target class mrthod "+method.getName());
		logger.debug("Target class args "+Arrays.toString(args));
		
		if((Integer)args[0]<0)
			args[0]=((Integer)args[0]*-1);
		
		if((Integer)args[0]==0)
			logger.error("Invalid Input"+ new IllegalArgumentException("Wrong orderId"));

		logger.info("Auditing");
		FileWriter fw=new FileWriter("E:\\Spring\\AudtingLog.txt",true);
		fw.write(args[0]+"order has come for approver at"+new Date()+"\n");
		fw.flush();
		fw.close();
	}

}
