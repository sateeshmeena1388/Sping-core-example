package com.wipro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={ServiceConfig.class,AopConfig.class,PersistanceConfig.class})
public class AppConfig {

}
