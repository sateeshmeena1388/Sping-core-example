package com.wipro.service;

import org.springframework.stereotype.Component;

@Component("target")
public class MethOperation {

	public int div(int x,int y)
	{
	return x/y;
	}
	
	public int sum(int x, int y)
	{
		return x+y;
	}
	public int mul(int x,int y)
	{
		return x*y;
	}
}
