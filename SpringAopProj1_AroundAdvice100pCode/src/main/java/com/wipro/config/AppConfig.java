package com.wipro.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wipro.service.IntrAmtCalCulator;
@Configuration
@ComponentScan(basePackages={"com.wipro.service,com.wipro.aspect"})
public class AppConfig {
	@Autowired
	private IntrAmtCalCulator proxy;
 @Bean(name="pfb")
	public ProxyFactoryBean createProxyFactoryBean()
	{
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTarget(proxy);
		pfb.setInterceptorNames("cache");
		pfb.setInterceptorNames("log");
		pfb.setInterceptorNames("pAdvice");
		return pfb;
	}
	@Bean(name="proxy")
	public Object createProxyObject()
	{
		return createProxyFactoryBean().getObject();
	}
}
