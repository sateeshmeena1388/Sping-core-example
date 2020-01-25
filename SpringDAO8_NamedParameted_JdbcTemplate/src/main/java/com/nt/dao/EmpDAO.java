package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nt.bo.EmpBO;
import com.nt.dto.EmpDTO;

public class EmpDAO {
	private static final String GET_EMP_DETAILS_BY_NAME="select ename from emp where empno=:eno";
	private static final String GET_EMP_DETAILS_BY_NO_QRY ="select  empno,ename,job,sal from emp where empno=:eno";
	//private static final String UPDATE_EMP_SALARY="update emp set sal=? where empno=?";
	private  final String EMP_INSERT_QRY="insert into emp(empno, ename,job,sal) values(:eno,:ename,:job,:sal)";
	private NamedParameterJdbcTemplate njt;
	
	
	
	public void setNjt(NamedParameterJdbcTemplate njt) {
		this.njt = njt;
	}
	public String findName(int no){
		//
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("eno", no);
		String name=njt.queryForObject(GET_EMP_DETAILS_BY_NAME,map,String.class);
		return name;
	}
	public EmpBO findEmpDetails(int no){
		MapSqlParameterSource params=new MapSqlParameterSource();
		params.addValue("eno", no);
		//execute
		EmpBO ebo=njt.queryForObject(GET_EMP_DETAILS_BY_NO_QRY, params, new EmpRowMapper());
		return ebo;
	}
	private static final class EmpRowMapper implements RowMapper<EmpBO>{

		@Override
		public EmpBO mapRow(ResultSet rs, int pos) throws SQLException {
			// TODO Auto-generated method stub
			EmpBO ebo=new EmpBO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4));
			return ebo;
		}
		
		}
	public int insertRecord(EmpBO ebo){
		BeanPropertySqlParameterSource pararms=new BeanPropertySqlParameterSource(ebo);
		int result= njt.update(EMP_INSERT_QRY,pararms);
		return result;
		
	}
	
}
