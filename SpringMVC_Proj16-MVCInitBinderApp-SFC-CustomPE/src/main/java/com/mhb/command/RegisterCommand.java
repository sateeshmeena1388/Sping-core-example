package com.mhb.command;

import java.util.Date;

public class RegisterCommand  {
private int sno;
private String name;
private Date dob,doj,dom;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}
public Date getDom() {
	return dom;
}
public void setDom(Date dom) {
	this.dom = dom;
}
@Override
public String toString() {
	return "RegisterCommand [sno=" + sno + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
}

}
