package com.mhb.service;

import java.util.Calendar;

public class WishServiceImpl implements WishService {

	@Override
	public String generateWishMsg() {
		// TODO Auto-generated method stub
		Calendar cal=null;
		String wMsg=null;
		int hour=0;
		cal=Calendar.getInstance();
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<=12)
			wMsg="Good Morning";
		else if(hour<=16)
			wMsg="Good AfterNoon";
		else if(hour<=20)
			wMsg="Good Evening";
		else
			wMsg="Good Night";
		System.out.println(hour);
		
		return wMsg;
	}

}
