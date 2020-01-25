package com.mhb.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mhb.config.RootConfigApp;
import com.mhb.config.WebMvcConfig;

public class WebAppIniliaizer implements WebApplicationInitializer {

	public WebAppIniliaizer() {
		System.out.println("WebInilizer");
	}
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext rootCtx, webCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic registration=null;
		//create root container and web application context container
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootConfigApp.class);
		webCtx=new AnnotationConfigWebApplicationContext();
		webCtx.register(WebMvcConfig.class);
		//create ContextLoaderListener having root AppContext container
		listener=new ContextLoaderListener(rootCtx);
		sc.addListener(listener);
		//Create DispatcherServlet  having web Application container
		servlet=new DispatcherServlet(webCtx);
		registration=sc.addServlet("dispatcher", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("*.htm");
	}

}
