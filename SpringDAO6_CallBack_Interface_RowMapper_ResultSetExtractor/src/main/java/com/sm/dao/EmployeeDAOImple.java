package com.sm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	EmployeeBO ebo=jt.queryForObject(GET_EMP_DETAILS_BY_NO, new RowMapper<EmployeeBO>(){
		
		public EmployeeBO mapRow(ResultSet rs, int pos) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("mapRowMapper");
			EmployeeBO ebo=new EmployeeBO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			
			return ebo;
		
		
}});
	return ebo;
	}

	@Override
	public List<EmployeeBO> getEmployee_By_Desg(String desg) {
		// TODO Auto-generated method stub
		List<EmployeeBO> list=jt.query(GET_EMP_DETAILS_BY_DESG, new Object[]{desg},new ResultSetExtractor<List<EmployeeBO>>(){

			@Override
			public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				System.out.println("-----ResultSetExtractor--");
				List<EmployeeBO> list=new ArrayList<EmployeeBO>();
				while(rs.next()){
					EmployeeBO ebo=new EmployeeBO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
					list.add(ebo);
				}
				
				return list;
			}
			
		});
		return list;
	}//annonymous class

}
