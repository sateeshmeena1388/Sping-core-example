package com.sm.bo;

public class EmployeeBO {
private int emono;
private String ename;
private String job;
private float sal;
public EmployeeBO(int emono, String ename, String job, float sal) {
	this.emono = emono;
	this.ename = ename;
	this.job = job;
	this.sal = sal;
}



public EmployeeBO() {
	System.out.println("---------EmployeeBO------");
}


public int getEmono() {
	return emono;
}

public void setEmono(int emono) {
	this.emono = emono;
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
