package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.service.ShoppingStore;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	//get bean
	ShoppingStore proxy=ctx.getBean("pfb",ShoppingStore.class);
	float billAmt=proxy.calculatorAmt("table", 350, 5);
	System.out.println(billAmt);
	((AbstractApplicationContext) ctx).close();
}
}
