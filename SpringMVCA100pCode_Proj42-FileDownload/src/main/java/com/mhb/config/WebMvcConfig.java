package com.mhb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mhb.controller")
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
	
	@Bean(name="multipartResolver")
	public  CommonsMultipartResolver createCmr(){
		CommonsMultipartResolver cmr=null;
		cmr=new CommonsMultipartResolver();
		cmr.setDefaultEncoding("utf-8");
		cmr.setMaxUploadSize(400000000);
		
		return cmr;
	}

}
