package com.mhb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.mhb.command.SearchCommand;
import com.mhb.dto.SearchDTO;
import com.mhb.dto.SearchResultDTO;
import com.mhb.service.EmployeeSearchService;






public class EmployeeSearchController extends AbstractCommandController {

	private EmployeeSearchService service;
	public void setService(EmployeeSearchService service) {
		this.service = service;
	}
	@Override
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object cmd, BindException errors)
			throws Exception {
		SearchCommand command=null;
		ModelAndView mav=null;
		SearchDTO sdto=null;
		List<SearchResultDTO> listdto=null;
		command=(SearchCommand) cmd;
		sdto=new SearchDTO();
		BeanUtils.copyProperties(command, sdto);
		listdto=service.findAllEmployee(sdto);
		mav=new ModelAndView();
		mav.setViewName("list_emps");
		mav.addObject("searchList",listdto);
		return mav;
	}

}
