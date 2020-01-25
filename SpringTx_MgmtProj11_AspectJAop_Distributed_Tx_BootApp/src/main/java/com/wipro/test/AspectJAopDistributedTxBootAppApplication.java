package com.wipro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.wipro.config.AopConfig;
import com.wipro.config.PersistanceConfig;
import com.wipro.config.ServiceConfig;
import com.wipro.service.TransferMoneyService;
/*@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,
		                     DataSourceTransactionManagerAutoConfiguration.class})
*/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})


@Import(value={AopConfig.class,PersistanceConfig.class,ServiceConfig.class})
public class AspectJAopDistributedTxBootAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TransferMoneyService proxy=null;
		ctx=SpringApplication.run(AspectJAopDistributedTxBootAppApplication.class, args);
	proxy=ctx.getBean("bankService",TransferMoneyService.class);
		try{
			
			System.out.println("Money transffer Successfully " +proxy.transferMoney(5002, 5001, 2000));
		}
		catch(Exception e)
		{
			System.out.println("Money not Transffer ");
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
	
	}
}
