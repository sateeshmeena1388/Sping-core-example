package com.wipro.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
	boolean flag=false;
private AuthenticateManager am;
	public void setAm(AuthenticateManager am) {
	this.am = am;
}
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		boolean flag=am.isAuthenticated();
		if(flag=false)
			throw new IllegalArgumentException("Invalid Crendtial");
		
	
		
	}

}
