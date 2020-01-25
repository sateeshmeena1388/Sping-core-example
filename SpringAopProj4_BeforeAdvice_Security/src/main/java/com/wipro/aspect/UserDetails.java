package com.wipro.aspect;

public class UserDetails {
private String user;
private String pwd;
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "UserDetails [user=" + user + ", pwd=" + pwd + "]";
}
public UserDetails(String user, String pwd) {
	this.user = user;
	this.pwd = pwd;
}

}
