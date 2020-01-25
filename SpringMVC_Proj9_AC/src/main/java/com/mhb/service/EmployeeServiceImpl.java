package com.mhb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mhb.bo.EmployeeBO;
import com.mhb.dao.EmployeeDAO;
import com.mhb.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDAO dao;
	public void setDao(EmployeeDAO dao) {
	this.dao = dao;
}
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> listdto=null;
		List<EmployeeBO> listbo=null;
		EmployeeDTO dto=null;
		listbo=dao.retriveAllEmployee();
		listdto=new ArrayList<>();
		for(EmployeeBO bo:listbo)
		{ dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		}
		
		return listdto;
	}

}

