package com.mhb.dao;

import java.util.List;

import com.mhb.bo.SearchBO;
import com.mhb.bo.SearchResultBO;



public interface EmployeeSearchDAO {
	
	public List<SearchResultBO> searchEmps(SearchBO bo);

}
