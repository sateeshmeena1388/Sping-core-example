package com.sm.service;

import com.sm.bo.StudentBo;
import com.sm.dao.StudentDAO;
import com.sm.dto.StudentDTO;

public class StudentService {
private StudentDAO dao;

public void setDao(StudentDAO dao) {
	this.dao = dao;
}

public StudentDTO searchStudentByNo(int no){
	StudentBo bo=dao.getStudentDetails(no);
	StudentDTO dto=new StudentDTO(bo.getno(),bo.getSname(), bo.getSadd());
	return dto;
}
}
