package com.wipro.service;

import java.util.Random;

public class PinGenerator {
public int generatedPin(int cardNo)
{
	//generated Atm pin
	Random rad=new Random();
	int pin=rad.nextInt(9999);
	return pin;
}
}
