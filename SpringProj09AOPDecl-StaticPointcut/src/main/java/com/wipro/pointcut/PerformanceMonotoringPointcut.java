package com.wipro.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.wipro.service.AirthMeticService;

public class PerformanceMonotoringPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> target) {
		if(target==AirthMeticService.class && method.getName().equals("add"))
		// TODO Auto-generated method stub
		return true;
		else
			return false;
	}

}
