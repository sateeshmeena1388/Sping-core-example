package com.mhb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mhb.service.WishService;

public class WishCotroller extends AbstractController {
private WishService service;
private String wishMsg=null;
	public void setService(WishService service) 
	{
	this.service = service;
     }
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
     wishMsg=service.generateWishMsg();
		return new ModelAndView("result","msg",wishMsg);
	}

}
