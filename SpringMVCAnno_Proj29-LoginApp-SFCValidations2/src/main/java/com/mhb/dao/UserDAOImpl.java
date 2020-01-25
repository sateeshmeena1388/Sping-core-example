package com.mhb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mhb.bo.UserBO;

@Repository("loginDAO")
public class UserDAOImpl implements UserDAO {
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PWD=?";
	@Autowired
private JdbcTemplate jt;
	@Override
	public int validate(UserBO bo) {
		int count=0;
		// TODO Auto-generated method stub
		count=jt.queryForObject(AUTH_QUERY,Integer.class ,bo.getUser(),bo.getPwd());
		return count;
	}

}
