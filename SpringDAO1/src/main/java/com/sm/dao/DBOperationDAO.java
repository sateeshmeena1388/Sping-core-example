package com.sm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperationDAO implements DBOperations {

	
	private static final String INSERT_QUERY="insert into emp(empno,ename,job,sal) values(?,?,?,?)"
			+ "";
	private static final String GET_EMP_SALARY="select sal from emp where empno=?";
	
	private static final String GET_EMP_DETAILS_BY_NO="select empno,ename,job,sal from emp where empno=?";
	private static final String GET_ALL_EMP_DETAILS="select  empno,ename,job,sal from emp";
	private static final String UPDATE_EMP_SALARY="update emp set sal=? where empno=?";
	private static final String DELETE_EMP="delete from emp where empno=?";
	
	//taking JdbcTemplate
	private JdbcTemplate jt;
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insert(int no, String ename,String job, int sal) {
		
		int result=jt.update(INSERT_QUERY, no,ename,job,sal);
		return result;
	}

	@Override
	public int getSalary(int no) {
		int result=jt.queryForObject(GET_EMP_SALARY,Integer.class, no);
		return result;
	}

	@Override
	public Map<String, Object> listEmpDetails(int no) {
		Map<String,Object> map=jt.queryForMap(GET_EMP_DETAILS_BY_NO,no);
		return map;
	}

	@Override
	public List<Map<String, Object>> listAllEmpDetails() {
		List<Map<String,Object>> list=jt.queryForList(GET_ALL_EMP_DETAILS);
		return list;
	}

	@Override
	public int updateEmpSalary(int no, int newsal) {
		int result=jt.update(UPDATE_EMP_SALARY, newsal,no);
		return result;
	}

	@Override
	public int delete(int no) {
		int result=jt.update(DELETE_EMP,no);
		return result;
	}


	

}
