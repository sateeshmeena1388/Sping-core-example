package com.nt.vo;

public class EmpVO {
private String eno;
private String name;
private String job;
private String sal;
public EmpVO(String eno, String name, String job, String sal) {
	super();
	this.eno = eno;
	this.name = name;
	this.job = job;
	this.sal = sal;
}

public String getEno() {
	return eno;
}
public void setEno(String eno) {
	this.eno = eno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getSal() {
	return sal;
}
public void setSal(String sal) {
	this.sal = sal;
}



}
