package com.wipro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={AopConfig.class,PersistanceConfig.class,ServiceConfig.class})
public class AppConfig {

}
