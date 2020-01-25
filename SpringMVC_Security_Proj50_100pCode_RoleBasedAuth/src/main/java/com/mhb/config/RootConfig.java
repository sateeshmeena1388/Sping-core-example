package com.mhb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={PeristanceConfig.class,SecurityConfig.class})
public class RootConfig {

}
