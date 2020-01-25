package com.mhb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mhb.bo.SearchBO;
import com.mhb.bo.SearchResultBO;
import com.mhb.dao.EmployeeSearchDAO;
import com.mhb.dto.SearchDTO;
import com.mhb.dto.SearchResultDTO;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {

	private EmployeeSearchDAO dao;
	
	public void setDao(EmployeeSearchDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<SearchResultDTO> findAllEmployee(SearchDTO dto) {
		// TODO Auto-generated method stub
		SearchBO bo=null;
		List<SearchResultBO> listbo=null;
		List<SearchResultDTO> listdto=null;
		SearchResultDTO rdto=null;
		bo=new SearchBO();
		BeanUtils.copyProperties(dto, bo);
		listbo=dao.searchEmps(bo);

		listdto=new ArrayList<>();
		for(SearchResultBO rbo:listbo){
		rdto=new SearchResultDTO();
		BeanUtils.copyProperties(rbo, rdto);
		listdto.add(rdto);
		
		}
		
		
		return listdto;
	}
}

