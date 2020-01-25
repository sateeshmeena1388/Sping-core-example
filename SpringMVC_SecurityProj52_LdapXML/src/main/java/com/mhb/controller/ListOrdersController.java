package com.mhb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.mhb.service.ListOrdersService;

public class ListOrdersController extends AbstractController {
	private ListOrdersService service;

	public void setService(ListOrdersService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
     List<String> orders=null;
     //use service
     orders=service.getOrders();
     return new ModelAndView("show_orders","orders",orders);
	}

}
