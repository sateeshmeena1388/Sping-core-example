package com.mhb.command;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.mhb.service")
public class ServiceConfig {
public ServiceConfig() {
System.out.println("serviceconfig");
}
}
