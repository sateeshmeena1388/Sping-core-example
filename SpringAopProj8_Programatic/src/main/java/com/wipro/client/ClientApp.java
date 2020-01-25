package com.wipro.client;

import org.springframework.aop.framework.ProxyFactory;

import com.wipro.aspect.PerformanceMonitoringAdvice;
import com.wipro.service.AirthMeticService;

public class ClientApp {
public static void main(String[] args) {

	//get proxy class object
	ProxyFactory facttory=null;
	AirthMeticService operation,proxy=null;
	PerformanceMonitoringAdvice advice=null;
	operation= new AirthMeticService();
	advice=new PerformanceMonitoringAdvice();
	facttory=new ProxyFactory();
	facttory.setTarget(operation);
	facttory.addAdvice(advice);
	//get proxy object
	proxy=(AirthMeticService) facttory.getProxy();
	
/*	System.out.println("Sum::"+proxy.add(1200, 200));
	System.out.println("sub::"+proxy.sub(2552, 566));
	System.out.println("mul::"+proxy.mul(52, 54));*/
}
}
