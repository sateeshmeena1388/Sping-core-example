package com.wipro.aspect;

import com.wipro.dao.AuthenticateDAO;

public class AuthenticateManager {
private ThreadLocal<UserDetails> tl=new ThreadLocal<UserDetails>();
private AuthenticateDAO dao;
public void setDao(AuthenticateDAO dao) {
	this.dao = dao;
}
public void signIn(String user,String pwd)
{
	UserDetails ud=new UserDetails(user,pwd);
	tl.set(ud);
}
public void signOut()
{
	tl.remove();
}
public boolean isAuthenticated()
{
	//get user details
	UserDetails ud=tl.get();
	boolean flag=dao.authenticate(ud);
	return flag;
}
}
