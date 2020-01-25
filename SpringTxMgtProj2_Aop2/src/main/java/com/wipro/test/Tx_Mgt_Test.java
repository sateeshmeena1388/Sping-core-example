package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.BankService;

public class Tx_Mgt_Test 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx=null;
    	
    	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
    	BankService proxy=ctx.getBean("bankService",BankService.class);
    	//call b.method
        System.out.println("Money transfer" +proxy.transferMoney(5001, 5002, 2000));
        System.out.println("Proxy Class: "+proxy.getClass().getName());
        ((AbstractApplicationContext) ctx).close();
    }
}
