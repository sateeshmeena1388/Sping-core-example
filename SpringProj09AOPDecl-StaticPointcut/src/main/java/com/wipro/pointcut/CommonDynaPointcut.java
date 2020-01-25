package com.wipro.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.wipro.service.AirthMeticService;

public class CommonDynaPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> target, Object... args) {
		// TODO Auto-generated method stub
		if(target==AirthMeticService.class && method.getName().equals("mul")
				&& (Integer)args[0]>=1000 && (Integer)args[1]>=1000)
			
		return true;
		else
			return false;
	}

}
