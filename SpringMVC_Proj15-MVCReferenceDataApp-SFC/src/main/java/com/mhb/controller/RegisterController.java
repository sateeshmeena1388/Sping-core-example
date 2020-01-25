package com.mhb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")
public class RegisterController extends SimpleFormController {
@Override
public Map<String ,List<String>> referenceData(HttpServletRequest request) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("RegisterController:refrenceData(-)");
	Map<String,List<String>> map=null;
	List<String> countries;
	List<String> courses;
	List<String> hobies;
	map=new HashMap<>();
	countries=new ArrayList();
	countries.add("india");
	countries.add("pakistan");
	countries.add("china");
	countries.add("japan");
	countries.add("singapoore");
	courses=new ArrayList();
	courses.add("JAVA");
	courses.add("PHP");courses.add(".NET");courses.add("data science");
	hobies=new ArrayList();
	hobies.add("Watching Movies");
	hobies.add("Listening Songs");
	hobies.add("Playing Games");
	hobies.add("Moving New Places");
	map.put("countriesList", countries);
	map.put("coursesList", courses);
	map.put("hobiesList", hobies);
	return map;
	
}
@Override
	public ModelAndView onSubmit(Object command, BindException errors) throws Exception {
		// TODO Auto-generated method stub
	ModelAndView modelAndView=null;
	modelAndView=new ModelAndView();
	modelAndView.setViewName("register_result");
	modelAndView.addObject("cmdData",command);
		return modelAndView;
	}
}
