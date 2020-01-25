package com.mhb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhb.service.WelcomeService;

@Controller
public class WishController {

	@Autowired
	private WelcomeService wishService;
	
	@RequestMapping(value="/home.htm")
	public String showHomePage(){
		return "home";
	}
	@RequestMapping(value="wish.htm")
	public String generateMsg(Map<String,Object>map){
		String msg=null;
		msg=wishService.generateService();
		//add to Model attribute
		map.put("wMsg", msg);
		return "result";	
	}
}
