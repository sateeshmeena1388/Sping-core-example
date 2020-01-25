package com.wipro.service;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class ShoppingStore {
public float calculatorAmt(String item,float price,int qty)
{
	return price*qty;
}
}
