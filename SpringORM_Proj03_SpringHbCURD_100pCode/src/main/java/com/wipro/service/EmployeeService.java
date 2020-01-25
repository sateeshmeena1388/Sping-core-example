package com.wipro.service;

import java.util.List;

import com.wipro.dto.EmployeeDTO;

public interface EmployeeService {
public String registeration(EmployeeDTO dto);
public List<EmployeeDTO> fetchAllEmployees();
public List<EmployeeDTO> fetchEmployeesByEmailDomain(String domain);
public String modifyEmailEmploeeByNo(int epid,String newmail);
public  String removeEmployeeByLastName(String surname1,String surname2,String surname3);
}
