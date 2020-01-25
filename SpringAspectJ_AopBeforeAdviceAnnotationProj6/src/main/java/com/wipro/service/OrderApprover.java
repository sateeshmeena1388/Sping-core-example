package com.wipro.service;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component("target")
public class OrderApprover {

public String approver(int orderid)
{

	//get current month
	Calendar cl=Calendar.getInstance();
	int h=cl.get(Calendar.DAY_OF_MONTH);
	System.out.println(h);
	if( h<=10 && h>=7)
		
	return "We don't accept this "+ orderid+ " order in rainy season";
	
	else
		return orderid+" order is approved";
}
}
