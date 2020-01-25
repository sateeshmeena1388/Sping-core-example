package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AppConfig;
import com.wipro.service.ShoppingStore;

public class AspectJAOP_AfterAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        proxy=ctx.getBean("target",ShoppingStore.class);
        System.out.println("First Shopping"+ proxy.generateBillAmt("Iphone8", 50000, 5));
    
        System.out.println("First Shopping"+ proxy.generateBillAmt("MI", 12000, 5));
       // System.out.println("First Shopping"+ proxy.generateBillAmt("Nokia", 10000, 2));
        System.out.println("Proxy class:"+proxy.getClass().getName());
        
        
        ((AbstractApplicationContext) ctx).close();
	}

}
