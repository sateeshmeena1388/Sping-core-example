package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.aspect.AuthenticateManager;
import com.wipro.service.IntrAmtCalculator;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	AuthenticateManager authManager=ctx.getBean("authManager",AuthenticateManager.class);
	//signIn
	authManager.signIn("rahul","arti");
	//call bussiness method
	IntrAmtCalculator proxy=ctx.getBean("pfb",IntrAmtCalculator.class);
	float amt=proxy.calculatorAmt(50000, 20, 5);
	System.out.println("Intr Amt: "+amt);
	//signout
	authManager.signOut();
	((AbstractApplicationContext) ctx).close();
}
}
