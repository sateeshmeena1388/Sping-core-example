package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.service.BankService;

public class TxMgt_AspectJAopAnnotation_Test 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=null;
    	
    	ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	BankService proxy=ctx.getBean("bankService",BankService.class);
    	//call b.method
    	try{
        System.out.println("Money Transfer " +proxy.transferMoney(5002, 5001, 2000));
        System.out.println("proxy Class:" +proxy.getClass().getName());
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Money not Transfer");
    	}
        ((AbstractApplicationContext) ctx).close();
    }
}
