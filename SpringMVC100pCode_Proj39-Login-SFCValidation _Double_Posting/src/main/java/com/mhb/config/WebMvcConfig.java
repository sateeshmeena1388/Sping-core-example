package com.mhb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mhb.handler.DoublePostingHandler;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mhb.controller,com.mhb.handler")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
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
	@Bean
 DoublePostingHandler doublePosting(){
		return new DoublePostingHandler();
	}	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		 registry.addInterceptor(doublePosting());
	}
}
