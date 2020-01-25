package com.wipro.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.OrderApprover;

public class AspectJAOP_BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OrderApprover proxy=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
        
        proxy=ctx.getBean("target",OrderApprover.class);
		System.out.println("Status:"+proxy.approver(1000));
        ((AbstractApplicationContext) ctx).close();
	}

}
