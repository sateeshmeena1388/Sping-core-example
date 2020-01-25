package com.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.sm.bo.EmployeeBO;

public class EmployeeDAOImple implements ListEmployeeDAO {
private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMPLOYEE WHERE EMPNO=?";
private static final String GET_EMP_DETAILS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMPLOYEE WHERE JOB=?";	

private JdbcTemplate jt;

public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}

@Override
public EmployeeBO getEmployeeBY_NO(int no) {
	// TODO Auto-generated method stub
EmployeeBO bo=jt.queryForObject(GET_EMP_DETAILS_BY_NO,
	
	(ResultSet rs, int pos)->{
		// TODO Auto-generated method stub
	
		EmployeeBO ebo=null;
		ebo=new EmployeeBO();
		ebo.setEmono(rs.getInt(1));
		ebo.setEname(rs.getString(2));
		ebo.setJob(rs.getString(3));
		ebo.setSal(rs.getFloat(4));
		
		return ebo;
	
	
},no);
return bo;
}

	@Override
	public List<EmployeeBO> getEmployee_By_Desg(String desg) {
		// TODO Auto-generated method stub
		List<EmployeeBO> listbo=new ArrayList<EmployeeBO>();
		jt.query(GET_EMP_DETAILS_BY_DESG, new EmpRowCallBackHandler(listbo),desg);

			
		return listbo;
	}//Lamdata Expression
private class EmpRowCallBackHandler implements RowCallbackHandler{
List<EmployeeBO> listbo=null;
	public EmpRowCallBackHandler(List<EmployeeBO> listbo) {
		this.listbo=listbo;
	}

	@Override
	public void processRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("processrow");
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		bo.setEmono(rs.getInt(1));
		bo.setEname(rs.getString(2));
		bo.setJob(rs.getString(3));
		bo.setSal(rs.getFloat(4));
		listbo.add(bo);
		
	}
	
}
}