package com.mhb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mhb.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String GET_ALL_EMPLOYEES="SELECT eno,ename,desg,sal FROM EMPLOYEES ";
	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public List<EmployeeBO> retriveAllEmployee() {
		// TODO Auto-generated method stub
		List<EmployeeBO> listbo=null;
		listbo=jt.query(GET_ALL_EMPLOYEES,new EmpExtractor());
		System.out.println("ListEmp"+listbo.size());
		return listbo;
	}
private class EmpExtractor implements ResultSetExtractor<List<EmployeeBO>>
{

	@Override
	public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		EmployeeBO bo=null;
		List<EmployeeBO> listbo=null;
		listbo=new ArrayList<>();
		while(rs.next()){
			 bo=new EmployeeBO();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSal(rs.getDouble(4));
			listbo.add(bo);
			
		}
		return listbo;
	}
	}
}
