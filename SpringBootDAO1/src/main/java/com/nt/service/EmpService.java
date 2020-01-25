package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmpService {
public int findEmpcount();
public List<EmployeeDTO> findEmployeeByDesg(String desg);
}
