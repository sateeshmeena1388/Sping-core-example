package com.sm.dao;

import java.util.List;
import java.util.Map;

public interface DBOperations {
	public int insert(int no, String ename, String job, int sal);

	public int getSalary(int no);

	public Map<String, Object> listEmpDetails(int no);
	public List<Map<String,Object>> listAllEmpDetails();

	public int updateEmpSalary(int no, int newsal);

	public int delete(int no);
}
