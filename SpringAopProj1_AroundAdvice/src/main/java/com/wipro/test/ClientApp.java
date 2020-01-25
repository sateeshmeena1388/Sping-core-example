package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.IntrAmtCalCulator;

public class ClientApp {
public static void main(String[] args) {
	//create ioc container
	ApplicationContext ctx=null;
	ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
	//get bean
	IntrAmtCalCulator proxy=ctx.getBean("pfb",IntrAmtCalCulator.class);
	System.out.println("Call Bussiness method");
	float intrAmt=proxy.calIntrAmt(80000, 2, 20);
	System.out.println("IntrAmt "+intrAmt);
	System.out.println("-----------------");
	float intrAmt1=proxy.calIntrAmt(50000, 5, 23);
	System.out.println(intrAmt1);
	System.out.println("--------------");
	float intrAmt2=proxy.calIntrAmt(90000, 5, 23);
	System.out.println(intrAmt2);
	System.out.println("Proxy class "+proxy.getClass()+"Proxy class name"+proxy.getClass().getName()+" Super class "+proxy.getClass().getSuperclass());
	((AbstractApplicationContext) ctx).close();
}
}
