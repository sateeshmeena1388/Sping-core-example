package com.mhb.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.mhb.servlet.TestServlet;

public class MyWebApplicationInitializer implements ServletContainerInitializer {
static{
	System.out.println("static block:MyWebInitializer");
}
public MyWebApplicationInitializer() {
	System.out.println("o-param Constructor::MyWebInitilizer");
}
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext ctx) throws ServletException {
		System.out.println("MyWebInitilizer::onStartup(-,-)");
		// Register servlet
		TestServlet ts=null;
		ServletRegistration.Dynamic registration=null;
	
		ts=new TestServlet();
		registration=ctx.addServlet("test", ts);
		registration.setLoadOnStartup(1);
		registration.addMapping("testurl");

	}

}
