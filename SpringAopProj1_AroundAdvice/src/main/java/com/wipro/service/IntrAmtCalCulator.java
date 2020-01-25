package com.wipro.service;

public class IntrAmtCalCulator {
public float calIntrAmt(float principle,float rate,float time){
	System.out.println("Target Class method");
	return (principle*rate*time)/100.0f;
}
}
