package com.mhb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mhb.service.ListOrdersService;

@Controller
public class ListOrdersController {
	@Autowired
	private ListOrdersService service;

	@RequestMapping("/list_orders.htm")
	public String process(Map<String,Object> map) throws Exception {
     List<String> orders=null;
     //use service
     orders=service.getOrders();
     map.put("orders",orders);
     return "show_orders";
	}
}