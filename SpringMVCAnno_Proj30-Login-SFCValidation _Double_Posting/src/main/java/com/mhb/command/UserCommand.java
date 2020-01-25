package com.mhb.command;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class UserCommand {
	@NotEmpty(message="user name is must")
private String user="arti";
	@NotEmpty(message="Password is must")
	@Size(min=4,max=10)
private String pwd="meena";
	@Range(min=1, max=100)
private int age;
	private String domains[];
	private Date dob;
public String[] getDomains() {
		return domains;
	}
	public void setDomains(String[] domains) {
		this.domains = domains;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
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
	return "UserCommand [user=" + user + ", pwd=" + pwd + ", age=" + age + ", domains=" + Arrays.toString(domains)
			+ ", dob=" + dob + "]";
}


}
