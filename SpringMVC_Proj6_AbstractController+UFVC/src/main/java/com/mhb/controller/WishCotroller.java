package com.mhb.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishCotroller extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
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
		return new ModelAndView("result","msg",wMsg);
	}

}
