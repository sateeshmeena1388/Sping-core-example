package com.wipro.service;

import org.springframework.stereotype.Service;

@Service("aic")
public class IntrAmtCalCulator {

	public float calcIntrAmpount(float pAmt,float time,float rate)
	{
		System.out.println("IntrAmtCaCulator:cacIntrAmount(---)");
		return (pAmt*time*rate)/100.0f;
	}
}
