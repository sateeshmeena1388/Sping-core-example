package com.sm.dao;

import java.util.List;

import com.sm.bo.StudentBo;

public interface StudentDAO {
public List<StudentBo> getStudentByAddrs(String addrs);
public StudentBo getStudentByNo(int no);
public int UpdateStudentDetailsByNo(StudentBo bo);
}
