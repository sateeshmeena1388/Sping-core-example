package com.wipro.client;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import com.wipro.aspect.CacheAdvice;
import com.wipro.aspect.PerformanceMonitoringAdvice;
import com.wipro.pointcut.CommonDynaPointcut;
import com.wipro.pointcut.PerformanceMonotoringPointcut;
import com.wipro.service.AirthMeticService;

public class ClientApp {
public static void main(String[] args) {

	//get proxy class object
	ProxyFactory facttory=null;
	AirthMeticService operation,proxy=null;
	
	operation= new AirthMeticService();

	facttory=new ProxyFactory();
	facttory.setTarget(operation);

	//default advisor
	
	NameMatchMethodPointcut nmp=new NameMatchMethodPointcut();
	nmp.setMappedNames("add","mul");
	DefaultPointcutAdvisor pmAdvisor=new DefaultPointcutAdvisor(nmp,new CacheAdvice());
	facttory.addAdvisor(pmAdvisor);
	//get proxy object
	proxy=(AirthMeticService) facttory.getProxy();
	
	System.out.println("Sum::"+proxy.add(1200, 200));
	System.out.println("sub::"+proxy.sub(2552, 566));
	System.out.println("mul::"+proxy.mul(52, 54));
}
}
