package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.PriceCalculator;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	PriceCalculator proxy=ctx.getBean("pfb",PriceCalculator.class);
	//call target method
	try {
		float price=proxy.calculator(9000.0f,560.f);
		System.out.println(price);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Internal problem "+e.getClass()+""+e.getMessage());
	}
	((AbstractApplicationContext) ctx).close();
}
}
