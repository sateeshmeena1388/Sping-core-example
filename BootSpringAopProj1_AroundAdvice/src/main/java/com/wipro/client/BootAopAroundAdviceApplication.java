package com.wipro.client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.wipro.config.AopConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.service.IntrAmtCalCulator;
@SpringBootApplication
@Import(value={ServiceConfig.class,AopConfig.class})
public class BootAopAroundAdviceApplication {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IntrAmtCalCulator proxy=null;
			ctx=SpringApplication.run(BootAopAroundAdviceApplication.class ,args);
//get Proxy Object
			proxy=ctx.getBean("proxy",IntrAmtCalCulator.class);
			System.out.println("Intr Amount" +proxy.calcIntrAmpount(100000, 20, 5));
			System.out.println("--------------------------------------");
			System.out.println("Intr Amount"+proxy.calcIntrAmpount(100000, 20, 2));
			((ConfigurableApplicationContext) ctx).close();
	}

}
