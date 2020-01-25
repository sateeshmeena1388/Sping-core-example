package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.OrderApprover;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	OrderApprover proxy=ctx.getBean("pfb",OrderApprover.class);
	//call bussiness method
	System.out.println("order Approver "+proxy.approverOrder(1234));
	System.out.println("-----------------------");
	System.out.println("order Approver "+proxy.approverOrder(-4561));
	System.out.println("------------------------");
	System.out.println("order Approver "+proxy.approverOrder(0));
	
	((AbstractApplicationContext) ctx).close();
}
}
