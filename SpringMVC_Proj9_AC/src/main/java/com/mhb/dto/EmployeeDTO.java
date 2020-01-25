package com.mhb.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
private int eno;
private String ename;
private String job;
private double sal;
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
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
@Override
public String toString() {
	return "EmployeeDTO [eno=" + eno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
}

}
