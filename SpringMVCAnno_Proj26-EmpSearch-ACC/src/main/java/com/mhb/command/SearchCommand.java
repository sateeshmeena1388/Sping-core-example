package com.mhb.command;

public class SearchCommand {
	private int eno;
	private String ename;
	private String job;
	private double salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "SearchCommand [eno=" + eno + ", ename=" + ename + ", job=" + job + ", salary=" + salary + "]";
	}
	

}
