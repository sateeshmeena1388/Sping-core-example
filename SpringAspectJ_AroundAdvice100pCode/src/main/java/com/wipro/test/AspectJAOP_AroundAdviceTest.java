package com.wipro.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.wipro.config.AopConfig;
import com.wipro.config.AppConfig;
import com.wipro.service.IntrAmtCalculator;

public class AspectJAOP_AroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrAmtCalculator proxy=null;
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
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
