package com.mhb.service;

import java.util.List;

import com.mhb.dto.StudentDTO;

public interface StudentService {
public List<StudentDTO> FetchAllStudentData();
public StudentDTO fetchStudentBySno(int sno);
public String modifyStudentByNo(StudentDTO dto);
public String removeStudentBy_Sno(int no);
public int fetchstudentNumber();
public String registerStudent(StudentDTO dto);

}
