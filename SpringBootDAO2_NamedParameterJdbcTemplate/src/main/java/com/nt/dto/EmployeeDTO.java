package com.nt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
private int empno;
private String ename;
private String job;
private int sallary;
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
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
public int getSallary() {
	return sallary;
}
public void setSallary(int sallary) {
	this.sallary = sallary;
}
@Override
public String toString() {
	return "EmployeeDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sallary=" + sallary + "]";
}

}
