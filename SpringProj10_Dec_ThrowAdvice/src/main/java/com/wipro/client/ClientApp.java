package com.wipro.client;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.Shopping;

public class ClientApp {
public static void main(String[] args) {
ApplicationContext ctx=null;
Shopping proxy=null;
float price=0.0f;
ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	
	proxy=ctx.getBean("pfb",Shopping.class);
	
	try{
		price=proxy.shopping(100, 10);
				System.out.println("price:"+price);
	}
	catch(SQLException se)
	{
		System.out.println("Client App"+se.getMessage());
	}
	((AbstractApplicationContext) ctx).close();
}
}
