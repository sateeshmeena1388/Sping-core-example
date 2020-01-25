package com.wipro.dao;

import java.util.List;

import com.wpro.domain.EmployeeHLO;

public interface EmployeeDAO {
public int insertRecords(EmployeeHLO emp);
public List<EmployeeHLO> getAllEmployees();
public List<EmployeeHLO> getEmployeesByLastName(String lName);
public List<EmployeeHLO> getEmployeesByEmailDomain(String domain);
public int updateEmployeeEmail(int empid,String newMail);
public int deleteEmployeeByEmpId(int empId);
public int deleteEmployeeByName(String surname);
public List<EmployeeHLO> getEmployeesByLastName(String surname,String surname2,String surname3);

}
