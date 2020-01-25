package com.sm.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
private int no;
private String name,job;
private float sal;
public EmployeeDTO() {
	System.out.println("---------EmpDto----------");
}


public EmployeeDTO(int no, String name, String job, float sal) {
	this.no = no;
	this.name = name;
	this.job = job;
	this.sal = sal;
}


public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
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
public float getSal() {
	return sal;
}
public void setSal(float sal) {
	this.sal = sal;
}


@Override
public String toString() {
	return "EmployeeDTO [no=" + no + ", name=" + name + ", job=" + job + ", sal=" + sal + "]";
}

}
