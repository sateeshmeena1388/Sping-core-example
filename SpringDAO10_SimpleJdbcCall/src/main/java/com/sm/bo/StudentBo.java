package com.sm.bo;

public class StudentBo {
private int no;
private String sname;
private String sadd;
public StudentBo() {
	// TODO Auto-generated constructor stub
}
public StudentBo(int no, String sname, String sadd) {
	super();
	this.no = no;
	this.sname = sname;
	this.sadd = sadd;
}
public int getno() {
	return no;
}
public void setno(int no) {
	this.no = no;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSadd() {
	return sadd;
}
public void setSadd(String sadd) {
	this.sadd = sadd;
}


}
