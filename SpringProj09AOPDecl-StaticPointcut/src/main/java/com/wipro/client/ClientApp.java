package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.AirthMeticService;

public class ClientApp {
public static void main(String[] args) {
ApplicationContext ctx=null;
AirthMeticService proxy=null;
ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	
	proxy=ctx.getBean("pfb",AirthMeticService.class);
	System.out.println("Sum::"+proxy.add(1200, 200));
	System.out.println("sub::"+proxy.sub(2552, 566));
	System.out.println("mul::"+proxy.mul(52, 54));
	((AbstractApplicationContext) ctx).close();
}
}
