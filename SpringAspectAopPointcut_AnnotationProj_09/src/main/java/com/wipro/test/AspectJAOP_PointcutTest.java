package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.MethOperation;

public class AspectJAOP_PointcutTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MethOperation proxy=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
        proxy=ctx.getBean("target",MethOperation.class);
        System.out.println(proxy.sum(15333, 1566));
        System.out.println("----------------------");
        System.out.println(proxy.mul(5666, 5444));
        System.out.println("---------------------");
        System.out.println(proxy.div(5000, 1500));
        
        ((AbstractApplicationContext) ctx).close();
	}

}
