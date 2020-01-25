package com.wipro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.wipro.aspect")
@EnableAspectJAutoProxy
public class AopConfig {

}
