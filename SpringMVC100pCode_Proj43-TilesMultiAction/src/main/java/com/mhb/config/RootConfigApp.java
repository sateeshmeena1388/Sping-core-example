package com.mhb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

public class RootConfigApp {
	public RootConfigApp() {
		System.out.println("rootAppCtx");
	}

}
