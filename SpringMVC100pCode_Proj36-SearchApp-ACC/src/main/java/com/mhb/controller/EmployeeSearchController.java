package com.mhb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mhb.command.SearchCommand;
import com.mhb.dto.SearchDTO;
import com.mhb.dto.SearchResultDTO;
import com.mhb.service.EmployeeSearchService;

@Controller
public class EmployeeSearchController {
	@Autowired
private EmployeeSearchService service;
	
	@RequestMapping("/search.htm")
	public String showHomePage(){
		return "search";
	}
	
	@RequestMapping("performsearch.htm")
	public String searchEmployee(Map<String,Object> map,@ModelAttribute("command") SearchCommand command){
		System.out.println("dfghjkl");
		ModelAndView modelAndView=new ModelAndView("list_emps");
		SearchDTO dto=null;
		List<SearchResultDTO> listDTO=null;
		//convert commad obj DTO class obj
		dto=new SearchDTO();
		BeanUtils.copyProperties(command, dto);
		//use serice
		listDTO=service.findEmployees(dto);
		map.put("empList", listDTO);
		modelAndView.addObject("Recard successfully search");
		
		return "list_emps" ;
	}
}
