package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.service.TransferMoneyService;

public class DTX_Transaction100pCodeTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null;;
		TransferMoneyService proxy=null;
		
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		proxy=ctx.getBean("bankService",TransferMoneyService.class);
		System.out.println("procry" +proxy);
		try{
		System.out.println("Transfer money " +proxy.transferMoney(5001, 5003, 6000));
		}
		catch(Exception e){
			System.out.println("Money not transfer");
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}

}
