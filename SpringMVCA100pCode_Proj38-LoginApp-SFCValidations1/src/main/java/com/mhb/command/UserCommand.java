package com.mhb.command;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class UserCommand {
	@NotEmpty(message="user name is must")
private String user="arti";
	@NotEmpty(message="Password is must")
	@Size(min=4,max=10)
private String pwd="meena";
	@Range(min=1, max=100)
private int age;
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


}
