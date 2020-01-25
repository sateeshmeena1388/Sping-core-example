package com.wipro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.wipro.config.AopConfig;
import com.wipro.config.PersistanceConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.service.TransferMoneyService;


@SpringBootApplication
@Import(value={AopConfig.class,PersistanceConfig.class,ServiceConfig.class})
public class AspectJAopDistributedTxBootAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TransferMoneyService proxy=null;
		ctx=SpringApplication.run(AspectJAopDistributedTxBootAppApplication.class, args);
	proxy=ctx.getBean("bankService",TransferMoneyService.class);
		try{
			
			System.out.println("Money transffer Successfully " +proxy.transferMoney(5001, 5001, 2000));
		}
		catch(Exception e)
		{
			System.out.println("Money not Transffer ");
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
	
	}
}
