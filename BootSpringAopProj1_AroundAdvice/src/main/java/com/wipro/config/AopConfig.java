package com.wipro.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wipro.service.IntrAmtCalCulator;
@Configuration
@ComponentScan(basePackages="com.wipro.aspect")
public class AopConfig {
	@Autowired private IntrAmtCalCulator iac;
	@Bean("pfb")
	public ProxyFactoryBean createProxyFactoryBean()
	{
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTarget(iac);
		pfb.setInterceptorNames("cacheAdvice","logAroundAdvice");
		return pfb;
	}
	@Bean("proxy")
	public Object createProxy()
	{
		return createProxyFactoryBean().getObject();
	}
}
