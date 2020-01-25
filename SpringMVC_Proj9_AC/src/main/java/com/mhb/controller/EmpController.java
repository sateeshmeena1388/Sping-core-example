package com.mhb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mhb.dto.EmployeeDTO;
import com.mhb.service.EmployeeService;

public class EmpController extends AbstractController {
private EmployeeService service=null;
	public void setService(EmployeeService service) {
	this.service = service;
}
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeDTO> listdto=null;
		listdto=service.getAllEmployee();
		ModelAndView mav=null;
		mav=new ModelAndView();
		mav.setViewName("list_emps");
		mav.addObject("listemps",listdto);
		return mav;
	}
}