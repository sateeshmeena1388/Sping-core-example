package com.sm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.sm.bo.StudentBo;
import com.sm.dao.StudentDAO;
import com.sm.dto.StudentDTO;

public class StudentServiceImpl  implements StudentService{
private StudentDAO dao;
public StudentServiceImpl() {
	// TODO Auto-generated constructor stub
}
public void setDao(StudentDAO dao) {
	this.dao = dao;
}

@Override
public List<StudentDTO> searchByAddrs(String addrs) {
	// TODO Auto-generated method stub
	List<StudentBo> listbo=null;
	List<StudentDTO> listdto=new ArrayList<StudentDTO>();
	//use dao
	listbo=dao.getStudentByAddrs(addrs);
listbo.forEach(bo->{
	StudentDTO dto=null;
	dto=new StudentDTO();
	BeanUtils.copyProperties(bo, dto);
	listdto.add(dto);
});
	return listdto;
}

@Override
public StudentDTO serachStudentByNo(int no) {
	// TODO Auto-generated method stub
	StudentBo bo=new StudentBo();

	bo=dao.getStudentByNo(no);
	StudentDTO dto=new StudentDTO();
	BeanUtils.copyProperties(bo, dto);
	return dto;
}

@Override
public String modifyStudentByNo(StudentDTO dto) {
	StudentBo bo=null;
	int count=0;
	bo=new StudentBo();
	//copy to bo
	bo.setNo(dto.getSno());bo.setName(dto.getSname());bo.setSadd(dto.getSadd());
	count=dao.UpdateStudentDetailsByNo(bo);
	System.out.println("Count" +count);
	if(count!=0)
	return "Find Emp and Modified"+count;
	else
		return "Emp not found ";
}

}
