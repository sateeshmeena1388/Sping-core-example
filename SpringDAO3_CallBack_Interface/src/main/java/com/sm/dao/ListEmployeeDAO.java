package com.sm.dao;

import java.util.List;

import com.sm.bo.EmployeeBO;

public interface ListEmployeeDAO {
public EmployeeBO getEmployeeBY_NO(int no);
public List<EmployeeBO> getEmployee_By_Desg(String desg);
}
