package com.nt.bo;

public class EmpBO {
private int eno;
private String ename;
private String job;
private float sal;
public EmpBO() {
	// TODO Auto-generated constructor stub
}
public EmpBO(int eno, String ename, String job, float sal) {
	super();
	this.eno = eno;
	this.ename = ename;
	this.job = job;
	this.sal = sal;
}
public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public float getSal() {
	return sal;
}
public void setSal(float sal) {
	this.sal = sal;
}

}
