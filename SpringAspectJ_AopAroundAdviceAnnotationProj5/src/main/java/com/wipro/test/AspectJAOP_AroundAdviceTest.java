package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wipro.service.IntrAmtCalculator;

public class AspectJAOP_AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrAmtCalculator proxy=null;
		ctx=new FileSystemXmlApplicationContext("src/main/java/com/wipro/cfgs/applicationContext.xml");
        proxy=ctx.getBean("target",IntrAmtCalculator.class);
        System.out.println("simple interest"+ proxy.calcSimpleIntrAmt(50000, 12, 5));
        System.out.println("----------------------------------------");
        System.out.println("simple interest"+ proxy.calcSimpleIntrAmt(40000, 12, 5));
        System.out.println("--------------------------------------------------------");
        System.out.println("Compund interest "+proxy.compoundIntrAmt(100000, 5, 12));
        System.out.println("------------------------------------------");
        System.out.println("Compund interest "+proxy.compoundIntrAmt(100000, 5, 12));
        System.out.println("Proxy class:"+proxy.getClass().getName());
        
        
        ((AbstractApplicationContext) ctx).close();
	}

}
