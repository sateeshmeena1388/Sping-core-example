package com.wipro.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.wipro.dao")
public class PersistanceConfig {

}
