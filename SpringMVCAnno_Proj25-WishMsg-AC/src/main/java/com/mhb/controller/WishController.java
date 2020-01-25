package com.mhb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhb.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService service;
	/*@RequestMapping("/wish.htm")
	public ModelAndView process(){
		String wMsg=null;
		wMsg=service.generateWishMessage();
		//create mav object
		return new ModelAndView("result","wMsg",wMsg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public ModelAndView process(HttpServletRequest req,HttpServletResponse res){
		String wMsg=null;
		wMsg=service.generateWishMessage();
		//create mav object
		return new ModelAndView("result","wMsg",wMsg);
	}*/
	
/*	@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map){
		String wMsg=null;
		wMsg=service.generateWishMessage();
		//create mav object
		map.put("wMsg", wMsg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Model model){
		String wMsg=null;
		wMsg=service.generateWishMessage();
		//create mav object
		model.addAttribute("wMsg",wMsg);
		return "result";
	}*/
	
	
/*	@RequestMapping("/wish.htm")
	public String process(ModelMap model){
		String wMsg=null;
		wMsg=service.generateWishMessage();
		//create mav object
		model.addAttribute("wMsg", wMsg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object> process(){
		String wMsg=null;
		Map<String,Object> map=null;
		wMsg=service.generateWishMessage();
		map=new HashMap<>();
		map.put("wMsg", wMsg);
		//create mav object
	
		return map;
	}*/
	
/*	@RequestMapping("/wish.htm")
	public Model process(){
		String wMsg=null;
		Model model=null;
		wMsg=service.generateWishMessage();
		model=new ExtendedModelMap();
	model.addAttribute("wMsg",wMsg);
		//create mav object
	
		return model;
	}*/
	
/*	@RequestMapping("/wish.htm")
	public ModelMap process(){
		String wMsg=null;
		ModelMap model=null;
		wMsg=service.generateWishMessage();
		model=new ModelMap();
	model.addAttribute("wMsg",wMsg);
		//create mav object
		return model;
	}*/
	
	@RequestMapping("/wish")
	public void process(Map<String,Object> map){
		String wMsg=null;
		
		wMsg=service.generateWishMessage();
		
	map.put("wMsg",wMsg);
	
	
	}
}
