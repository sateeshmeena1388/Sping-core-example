package com.mhb.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
		return "login";
		
	}*/
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public String showForm(@ModelAttribute("userCmd") UserCommand cmd){
		//return LVN
		return "login";
	}
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String processForm(Map<String,Object>map,@Valid @ModelAttribute("userCmd") UserCommand cmd,BindingResult errors){
		UserDTO dto=null;
		String result=null;
	
		//convert command class obj to DTO class obj
		dto=new UserDTO();
		System.out.println(cmd.getUser()+"---------"+cmd.getPwd());
		BeanUtils.copyProperties(cmd, dto);
		result=service.authenticate(dto);
		map.put("result", result);
		map.put("cmdData", cmd);
		
		return "result";
	}
	@ModelAttribute("dmnList")
	public List<String> populateDomains(){
		List<String> domains=null;
		domains=new ArrayList<>();
	domains.add("Gamil");domains.add("Yahoo");domains.add("Hotmail");
	return domains;
	}
	@InitBinder
	public void myInitBinder(WebDataBinder binder){
		SimpleDateFormat sdf=null;
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
