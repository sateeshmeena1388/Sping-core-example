package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.StudentBO;
import com.nt.dao.RegistrationDAO;
import com.nt.dto.StudentDTO;

public class StudentService {
private RegistrationDAO dao;

public void setDao(RegistrationDAO dao) {
	this.dao = dao;
}
public String registStudent(List<StudentDTO> listdto){
	//convert to listdto listbo
	List<StudentBO> listbo=new ArrayList<>();
	for(StudentDTO dto:listdto){
		StudentBO bo=new StudentBO(dto.getNo(),dto.getName(),dto.getSadd());
		listbo.add(bo);
		
	}
	//use dao
	boolean status=dao.insert(listbo);
	if(status)
	
	return "Batch Insertion success";
	else
		return "Batch Insertion failed";
}
}
