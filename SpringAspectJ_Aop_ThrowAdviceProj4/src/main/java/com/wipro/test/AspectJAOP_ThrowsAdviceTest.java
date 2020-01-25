package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.MathDemo;

public class AspectJAOP_ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MathDemo proxy=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
       proxy=ctx.getBean("target",MathDemo.class);
       System.out.println("Divided operation:"+proxy.div(155, 15));
       System.out.println("-------------------------------------");
       System.out.println("Divided operation:"+proxy.div(155, 0));
        
        ((AbstractApplicationContext) ctx).close();
	}

}
