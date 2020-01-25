package com.sm.service;

import java.util.ArrayList;
import java.util.List;

import com.sm.bo.EmployeeBO;
import com.sm.dao.ListEmployeeDAO;
import com.sm.dto.EmployeeDTO;

public class EmployeeService {
private ListEmployeeDAO dao;

public void setDao(ListEmployeeDAO dao) {
	this.dao = dao;
}
public EmployeeDTO searchEmpByNo(int no){
	//use dao
	EmployeeBO ebo=dao.getEmployeeBY_NO(no);
	//transfering bo to dto
	EmployeeDTO dto=new EmployeeDTO(ebo.getEmono(),ebo.getEname(),ebo.getJob(),ebo.getSal());
	if(dto!=null)
		return dto;
	else
		return null;
}
public List<EmployeeDTO> searchEmpByDesg(String desg){
	//use dao class
	List<EmployeeBO> listbo=dao.getEmployee_By_Desg(desg);
	//copy bot dto
	List<EmployeeDTO> listdto=new ArrayList<EmployeeDTO>();
	for(EmployeeBO bo:listbo){
		EmployeeDTO dto= new EmployeeDTO(bo.getEmono(),bo.getEname(),bo.getJob(),bo.getSal());
	
	listdto.add(dto);
	}
	if(listdto!=null)
		return listdto;
	else
		return null;
}

}
