package com.mhb.service;

import java.util.ArrayList;
import java.util.List;

public class ListOrdersServiceImpl implements ListOrdersService {

	@Override
	public List<String> getOrders() {
		List<String> orders=null;
		   orders=new ArrayList<>();
		   orders.add("watch");
		   orders.add("mobile");
		   orders.add("shirt");
	       return orders;
	}

}
