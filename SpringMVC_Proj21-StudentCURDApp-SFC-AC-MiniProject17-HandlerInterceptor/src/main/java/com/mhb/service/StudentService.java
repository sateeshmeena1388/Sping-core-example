package com.mhb.service;

import java.util.List;

import com.mhb.dto.StudentDTO;



public interface StudentService {
	public List<StudentDTO>  fetchAllStudents();
	public StudentDTO fetchStudentByNo(int no);
	public String modifyStudentByNo(StudentDTO dto);
	public String  registerStudent(StudentDTO dto);
	public int  fetchStudentNumber();

}
