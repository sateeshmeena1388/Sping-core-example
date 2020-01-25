package com.wipro.service;

import org.springframework.stereotype.Component;

@Component("target")
public class IntrAmtCalculator {
public float calcSimpleIntrAmt(float amt,float time,float rate)
{
	System.out.println("Simple Interest");
	return (amt*time*rate)/100.0f;
}
public float compoundIntrAmt(float p,float r,float t)
{
	System.out.println("Compund interested");
	return (float)(p*Math.pow((1+r/100.0f),t)-p);
	
	/*
	 * If an amount of $5,000 is deposited into a savings account at an annual interest rate of 5%, compounded monthly, the value of the investment after 10 years can be calculated as follows...

   P = 5000. r = 5/100 = 0.05 (decimal). n = 12. t = 10.

   If we plug those figures into the formula, we get the following (note that ^ indicates 'to the power of'):

   A = 5000 (1 + 0.05 / 12) ^ (12(10)) = 8235.05.

   So, the investment balance after 10 years is $8,235.05.
	 * 
	 * 
	 * Compound interest formula (including principal):

		A = P(1+r/n)(nt)*/
}
}
