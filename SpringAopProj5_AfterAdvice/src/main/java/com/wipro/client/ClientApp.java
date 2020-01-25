package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.ShoppingStore;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	ShoppingStore proxy=ctx.getBean("pfb",ShoppingStore.class);
	float billAmt=proxy.calculatorAmt("table", 350, 5);
	System.out.println(billAmt);
	((AbstractApplicationContext) ctx).close();
}
}
