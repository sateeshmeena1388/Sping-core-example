package com.sm.vo;

public class StudentVo {
private String sno;
private String sname;
private String sadd;
public StudentVo() {
	// TODO Auto-generated constructor stub
}
public StudentVo(String sno, String sname, String sadd) {
	super();
	this.sno = sno;
	this.sname = sname;
	this.sadd = sadd;
}
public String getSno() {
	return sno;
}
public void setSno(String sno) {
	this.sno = sno;
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
