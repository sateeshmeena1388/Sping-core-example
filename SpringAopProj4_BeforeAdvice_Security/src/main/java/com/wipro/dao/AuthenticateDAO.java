package com.wipro.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.jdbc.core.JdbcTemplate;


import com.wipro.aspect.UserDetails;

public class AuthenticateDAO {
private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	private static Logger logger=null;
	static{
		logger=Logger.getLogger(AuthenticateDAO.class);
		PropertyConfigurator.configure("src/main/java/com/wipro/commons/log.properties");
	}
	private static final String AUTH_QRY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PWD=?";
	
	public boolean authenticate(UserDetails ud)
	{
		int cnt;
		logger.error(cnt = jt.queryForObject(AUTH_QRY,Integer.class,ud.getUser(),ud.getPwd()));
		System.out.println("list"+cnt);
		if(cnt==0)
		return false;
	else
		return true;

	}
	
}
