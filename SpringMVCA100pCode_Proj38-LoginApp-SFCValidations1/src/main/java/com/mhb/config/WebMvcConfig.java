package com.mhb.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mhb.controller,com.mhb.validator")


public class WebMvcConfig  {

	@Bean
	public  InternalResourceViewResolver createIvr(){
		InternalResourceViewResolver ivr=null;
		ivr=new InternalResourceViewResolver();
		ivr.setPrefix("/WEB-INF/pages/");
		ivr.setSuffix(".jsp");
		return ivr;
	}
	

	@Bean
public PropertyPlaceholderConfigurer proprties(){
	PropertyPlaceholderConfigurer props=null;
	props=new PropertyPlaceholderConfigurer();
	props.setBeanName("com/mhb/commons/validator");
	return props;
}	
}
