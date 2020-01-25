package com.mhb.service;

import org.springframework.beans.BeanUtils;

import com.mhb.bo.StudentBO;
import com.mhb.dao.StudentDAO;
import com.mhb.dto.StudentDTO;

public class StudentServiceImple implements StudentService {

	private StudentDAO dao;
	
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public String registation(StudentDTO dto) {
		// TODO Auto-generated method stub
		StudentBO bo=null;
		long count=0;
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.insert(bo);
		if(count==0)
			
		    return "Sucessful Registartion";
		else
			
			return "Registration failed";
	}

}
