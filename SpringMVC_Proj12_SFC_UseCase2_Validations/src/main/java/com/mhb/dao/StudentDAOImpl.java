package com.mhb.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mhb.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
private static final String ST_REG_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	private JdbcTemplate jt;
	private int count=0;
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	@Override
	public Long insert(StudentBO bo) {
		// TODO Auto-generated method stub
		count=jt.update(ST_REG_QUERY,bo.getSno(),bo.getSname(),bo.getSadd());
		return (long) count;
	}

}
