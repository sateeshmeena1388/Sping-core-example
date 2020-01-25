package com.sm.service;

import java.util.List;
import java.util.Map;

import com.sm.dao.DBOperationDAO;

public class DBOperationsService {
	private DBOperationDAO dao = null;

	public void setDao(DBOperationDAO dao) {
		this.dao = dao;
	}

	public String registarEmp(int no, String ename, String job, int sal) {
		int result = dao.insert(no, ename, job, sal);
		if (result == 0)
			return no + "Emp not registared";
		else
			return no + "emp sucessful registration";
		
	}
	public int showSalary(int no) {
		int salary=dao.getSalary(no);
		return salary;
	}
	public String hikeSalary(int no) {
		//write bilogic
		int salary=showSalary(no);
		int newsal=0;
		if(salary>=50000)
			newsal=Math.round(salary+salary*0.1f);
		else
			newsal=Math.round(salary+salary*0.2f);
		int result=dao.updateEmpSalary(no, newsal);
		if(result==0)
			return no+ "Emp no hike Salry";
		else
			return no + "Emp hiked salary";
		
	}
	
	public Map<String,Object> getEmpdetails(int no)throws Exception{
		Map<String,Object> map=dao.listEmpDetails(no);
		return map;
	}
	
	
public List<Map<String,Object>> getAllEmpDetails() throws Exception{
	List<Map<String,Object>> list=dao.listAllEmpDetails();
	if(list!=null)
		return list;
	else
		throw new Exception("Employee not found");
}
public String fireEmp(int eno) {
	int result=dao.delete(eno);
	if(result==0)
		return eno+ "Employee not found";
	else
		return "Employee Detleted";
}
}
