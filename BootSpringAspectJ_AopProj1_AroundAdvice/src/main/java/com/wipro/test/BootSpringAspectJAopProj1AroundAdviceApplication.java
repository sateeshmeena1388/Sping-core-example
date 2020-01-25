package com.wipro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.wipro.config.AopConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.service.MethOperation;

@SpringBootApplication
@Import(value={AopConfig.class,ServiceConfig.class})
public class BootSpringAspectJAopProj1AroundAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MethOperation proxy=null;
	ctx=SpringApplication.run(BootSpringAspectJAopProj1AroundAdviceApplication.class, args);
	proxy=ctx.getBean("target",MethOperation.class);
	
	System.out.println("Sum"+ proxy.sum(20052, 3555));
	System.out.println("-------------------------");
	System.out.println("Mul"+ proxy.mul(1544, 155));
	System.out.println("-------------------------");
	System.out.println("Div"+proxy.div(155, 52));
	((ConfigurableApplicationContext) ctx).close();
	}
}
