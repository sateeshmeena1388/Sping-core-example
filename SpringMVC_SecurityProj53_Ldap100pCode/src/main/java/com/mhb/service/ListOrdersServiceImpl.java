package com.mhb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListOrdersServiceImpl implements ListOrdersService {

	@Override
	public List<String> getOrders() {
		List<String> orders=null;
		   orders=new ArrayList<>();
		   orders.add("Watch");
		   orders.add("Mobile");
		   orders.add("Shirt");
	       return orders;
	}

}
