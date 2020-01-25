package com.mhb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mhb.controller,com.mhb.validator")
public class WebMvcConfig {
	public WebMvcConfig() {
		System.out.println("webconfig");
	}
	@Bean
	public  InternalResourceViewResolver createIvr(){
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
	@Bean
public ResourceBundleMessageSource createRbm(){
	ResourceBundleMessageSource rbms=null;
	rbms=new ResourceBundleMessageSource();
	rbms.setBasename("com/mhb/commons/validator");
	return rbms;
}
}
