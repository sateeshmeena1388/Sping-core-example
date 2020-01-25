package com.mhb.service;

import java.util.List;

import com.mhb.dto.SearchDTO;
import com.mhb.dto.SearchResultDTO;

public interface EmployeeSearchService {
	public List<SearchResultDTO> findEmployees(SearchDTO dto); 

}
