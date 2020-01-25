package com.wipro.aspect;

import java.io.FileWriter;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;
@Component("coupon")
public class DiscountCouponAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		float billAmt=(Float)returnValue;
		//we can not modify
		billAmt=billAmt+100;
		returnValue=billAmt;
		String msg=null;
		if(billAmt>50000)
			msg="Avail 30% Discount on next purchase";
		else if(billAmt>30000)
			msg="Avail 20% Dicount on Next purchase";
		else
			msg="Avail 10% Discout on next purchase";
		//store Discount coupon in a file
		FileWriter fw=new FileWriter("D:\\coupon.txt");
		fw.write(msg);
		fw.flush();
		fw.close();
		
		
	}

}
