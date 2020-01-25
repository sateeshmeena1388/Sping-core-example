package com.wipro.service;

public class PriceCalculator {
public float calculator(float price,float qty) throws Exception
{
	if(price==0.0f||qty==0.0f)
		throw new IllegalAccessException("price and qty must not be zero");
	return price*qty;
}
}
