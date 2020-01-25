package com.wipro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.wipro.config.AopConfig;
import com.wipro.config.PersistanceConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.service.BankService;

@SpringBootApplication
@Import(value={PersistanceConfig.class,ServiceConfig.class,AopConfig.class})
public class AspectJAopTxBootAppApplication {
	

	public static void main(String[] args) {
		ApplicationContext ctx =null;
		BankService proxy=null;
		ctx =SpringApplication.run(AspectJAopTxBootAppApplication.class, args);
	proxy=ctx.getBean("bankService",BankService.class);
	try{
		System.out.println("Money Transfer "+proxy.transferMoney(5001, 5002, 5000));
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("money not transfer");
	}
	((ConfigurableApplicationContext) ctx).close();
	}
	
}
