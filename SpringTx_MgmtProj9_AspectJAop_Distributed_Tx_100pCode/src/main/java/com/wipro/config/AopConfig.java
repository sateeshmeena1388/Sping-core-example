package com.wipro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
@Configuration
@EnableTransactionManagement
public class AopConfig {
	@Bean
	public  UserTransactionImp  createUserTransactionService()throws Exception{
		   UserTransactionImp  atomikosUT=null;
		   atomikosUT=new UserTransactionImp();
		   atomikosUT.setTransactionTimeout(300);
		   return atomikosUT;
	}
	
	@Bean
	public  UserTransactionManager  createUserTransactionManager()throws Exception{
		   UserTransactionManager atomikosTxMgmr=null;
		   atomikosTxMgmr=new UserTransactionManager();
		   atomikosTxMgmr.setForceShutdown(true);
		   return atomikosTxMgmr;
	}//method
	
	@Bean(name="dTxMgmr")
	public  JtaTransactionManager  createJtaTxManager()throws Exception{
		return new JtaTransactionManager(createUserTransactionService(),
	createUserTransactionManager());
	}//method
}
