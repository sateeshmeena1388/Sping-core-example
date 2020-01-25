package com.wipro.service;

import org.springframework.stereotype.Component;

@Component("target")
public class ShoppingStore {
public float generateBillAmt(String item,float price,float qty)
{
	return price*qty;
}
}
