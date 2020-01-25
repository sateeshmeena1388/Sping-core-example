package com.mhb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.mhb.bo.StudentBO;
import com.mhb.dao.StudentDAO;
import com.mhb.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
private StudentDAO dao;

public void setDao(StudentDAO dao) {
	this.dao = dao;
}

	@Override
	public List<StudentDTO> FetchAllStudentData() {
		// TODO Auto-generated method stub
		 List<StudentDTO> listStDTO=new ArrayList<>();;
		StudentDTO stdto=null;
		List<StudentBO> listBo=null;
	
		listBo=dao.getAllStudent();
		for(StudentBO sbo:listBo){
			
		stdto=new StudentDTO();
		stdto.setSno(sbo.getSno());
		stdto.setSname(sbo.getSname());
		stdto.setSadd(sbo.getSadd());
			listStDTO.add(stdto);
			System.out.println(listStDTO.size());
		}
		
		return listStDTO;
	}

	@Override
	public StudentDTO fetchStudentBySno(int sno) {
		// TODO Auto-generated method stub
		StudentBO bo=null;
		StudentDTO stDto=null;
		//use DAO
		bo=dao.getStudentByNo(sno);
		System.out.println("--------------------------"+bo.getSno());
		//convert bo to DTO
		stDto=new StudentDTO();
		BeanUtils.copyProperties(bo, stDto);
		
		return stDto;
	}

	@Override
	public String modifyStudentByNo(StudentDTO dto) {
		// TODO Auto-generated method stub
		int count=0;
		StudentBO bo=null;
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.updateStudentByNo(bo);
		if(count==0)
			
		return dto.getSno()+"Updation failed";
		else
			
		return dto.getSno()+"Sucessfully Updated";
	}

	@Override
	public String removeStudentBy_Sno(int no) {
		// TODO Auto-generated method stub
	
		dao.deleteStudentByNo(no);
		
		return "Successfully Student deleted";
	}

	@Override
	public int fetchstudentNumber() {
		// TODO Auto-generated method stub
		int sno=0;
		sno=dao.generateStudentNumber();
		return sno;
	}

	@Override
	public String registerStudent(StudentDTO dto) {
		// TODO Auto-generated method stub
		StudentBO bo=null;
		int count=0;
		bo=new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.insertStudent(bo);
		if(count==0)
		return "Student Registration Successfully";
		else
			return "Student Registration failed";	
		}

}
