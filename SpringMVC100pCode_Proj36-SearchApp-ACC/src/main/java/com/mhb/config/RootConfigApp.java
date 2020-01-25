package com.mhb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mhb.command.ServiceConfig;

@Configuration
@Import(value={ServiceConfig.class,PersistannceConfig.class})
public class RootConfigApp {
	public RootConfigApp() {
		System.out.println("rootAppCtx");
	}

}
