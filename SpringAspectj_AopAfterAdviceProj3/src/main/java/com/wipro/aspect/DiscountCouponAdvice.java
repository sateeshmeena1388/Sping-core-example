package com.wipro.aspect;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;

public class DiscountCouponAdvice {
public void generteCoupon(JoinPoint jp,float billAmt)throws Throwable
{
	String couponMsg="";
	if(billAmt>=50000)
		couponMsg="Avail 30% Discount on next Purchase";
	else if(billAmt>=30000)
		couponMsg="Avail 20% Discount on next purchase";
	else if(billAmt>=20000)
		couponMsg="Avail 10% Discount on next purchar";
	FileWriter fw=new FileWriter("e:\\coupon.log");
	fw.write(couponMsg);
	fw.flush();
	fw.close();
}
}
