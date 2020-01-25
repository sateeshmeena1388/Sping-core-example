package com.wipro.service;

import org.springframework.stereotype.Component;

@Component("targetBean")
public class IntrAmtCalCulator {
public float calIntrAmt(float principle,float rate,float time){
	System.out.println("Target Class method");
	return (principle*rate*time)/100.0f;
}
}
