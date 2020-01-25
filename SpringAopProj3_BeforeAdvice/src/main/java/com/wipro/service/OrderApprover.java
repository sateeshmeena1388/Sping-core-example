package com.wipro.service;

import java.util.Calendar;

public class OrderApprover {
public String approverOrder(int orderId)
  {
	Calendar cl=Calendar.getInstance();
	//get system date
	int month=cl.get(Calendar.MONTH);
	if(month>=7 && month<=10)
		return orderId+"order is  approver";
	else
		return orderId+"order is not Approver";
  }
}
