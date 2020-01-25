package com.wipro.service;

public class MathDemo {
public float div(int x,int y)
{
	if(y==0)
		throw new ArithmeticException("Divider can not Zero");
	else
		return (float)x/y;
}
}
