package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.PinGenerator;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	PinGenerator proxy=ctx.getBean("pfb",PinGenerator.class);
	int pin=proxy.generatedPin(8888);
	System.out.println("Generated pin:"+pin);
	((AbstractApplicationContext) ctx).close();
}
}
