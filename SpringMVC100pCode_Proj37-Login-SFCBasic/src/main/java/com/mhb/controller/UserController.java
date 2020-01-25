package com.mhb.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mhb.command.UserCommand;
import com.mhb.dto.UserDTO;
import com.mhb.service.LoginService;

@Controller
public class UserController {
	@Autowired
private LoginService service;
	/*@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(Map<String,Object>map){
		UserCommand commad=null;
		commad=new UserCommand();
		map.put("userCmd", commad);
		//return logical name
		return "login";
		
	}*/
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("userCmd")UserCommand cmd){
		//return lvn
		return "login";
		
	}
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object>map,@ModelAttribute("userCmd") UserCommand cmd){
		UserDTO dto=null;
		String result=null;
		//convert command class obj to DTO class obj
		dto=new UserDTO();
		System.out.println(cmd.getUser()+"---------"+cmd.getPwd());
		BeanUtils.copyProperties(cmd, dto);
		result=service.authenticate(dto);
		map.put("result", result);
		
		return "login";
	}
}
