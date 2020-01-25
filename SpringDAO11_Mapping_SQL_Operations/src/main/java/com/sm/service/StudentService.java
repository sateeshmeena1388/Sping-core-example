package com.sm.service;

import java.util.List;

import com.sm.dto.StudentDTO;

public interface StudentService {
public List<StudentDTO> searchByAddrs(String addrs);
public StudentDTO serachStudentByNo(int no);
public String modifyStudentByNo(StudentDTO dto);
}
