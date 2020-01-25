package com.nt.dto;

import java.io.Serializable;

public class EmpDTO  implements Serializable{
	private int eno;
	private String ename;
	private String job;
	private float sal;
	public EmpDTO(int eno, String ename, String job, float sal) {
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
	@Override
	public String toString() {
		return "EmpDTO [eno=" + eno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	
}
