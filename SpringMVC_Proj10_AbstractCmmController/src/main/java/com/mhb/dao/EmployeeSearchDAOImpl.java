package com.mhb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mhb.bo.SearchBO;
import com.mhb.bo.SearchResultBO;

public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {

	private static final String Search_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGRNO FROM EMP WHERE (EMPNO IS NOT NULL AND EMPNO=?) OR (ENAME IS NOT NULL AND ENAME=?) OR (JOB IS NOT NULL AND JOB=?) OR (SAL IS NOT NULL AND SAL=?)";
	
	private JdbcTemplate jt;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public List<SearchResultBO> searchEmps(SearchBO bo) {
		// TODO Auto-generated method stub
		List<SearchResultBO> listbo=null;
		listbo=jt.query(Search_EMP_QUERY,new SearchExtractor(),bo.getEno(),bo.getEname(),bo.getJob(),bo.getSal());
		System.out.println("ListEmp"+listbo.size());
		return listbo;
	}
private class SearchExtractor implements ResultSetExtractor<List<SearchResultBO>>
{

	@Override
	public List<SearchResultBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		
		SearchResultBO rbo=null;
		List<SearchResultBO> listbo=null;
		listbo=new ArrayList<>();
		while(rs.next()){
			 rbo=new SearchResultBO();
			rbo.setEno(rs.getInt(1));
			rbo.setEname(rs.getString(2));
			rbo.setJob(rs.getString(3));
			rbo.setSal(rs.getDouble(4));
			rbo.setDeptNo(rs.getInt(5));
			rbo.setMgrNo(rs.getInt(6));
			listbo.add(rbo);
			
		}
		return listbo;
	}
	}
}
