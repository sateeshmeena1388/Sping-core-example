package com.sm.bo;

public class EmployeeBO {
private int empno;
private String ename;
private String job;
private float sal;
public EmployeeBO(int empno, String ename, String job, float sal) {
	this.empno = empno;
	this.ename = ename;
	this.job = job;
	this.sal = sal;
}



public EmployeeBO() {
	System.out.println("---------EmployeeBO------");
}


public int getempno() {
	return empno;
}

public void setempno(int empno) {
	this.empno = empno;
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
