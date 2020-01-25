package com.wipro.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.AfterReturningAdvice;

public class CheckPinAdvice implements AfterReturningAdvice{

	public void afterReturning(Object retVal, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("generated pin: "+retVal);
		System.out.println("Target class: "+target.getClass());
		System.out.println("Target method: "+method.getName());
		System.out.println("target method args : "+Arrays.toString(args));
		int cardNo=(Integer)args[0]+100;
		//get retur value
		int pin =(Integer)retVal;
		//check the pin
		if(pin<=999)
			throw new IllegalArgumentException("weak pin generated");
	}

}
