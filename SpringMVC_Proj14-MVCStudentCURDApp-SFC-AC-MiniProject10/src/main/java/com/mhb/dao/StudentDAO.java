package com.mhb.dao;

import java.util.List;

import com.mhb.bo.StudentBO;

public interface StudentDAO {
public List<StudentBO> getAllStudent();
public StudentBO getStudentByNo(int no);
public int updateStudentByNo(StudentBO bo);
public void deleteStudentByNo(int no);
public int generateStudentNumber();
public int insertStudent(StudentBO bo);
}
