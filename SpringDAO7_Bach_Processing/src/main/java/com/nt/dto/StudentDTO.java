package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable{
private int no;
private String name;
private String sadd;
public StudentDTO(int no, String name, String sadd) {
	super();
	this.no = no;
	this.name = name;
	this.sadd = sadd;
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
public String getSadd() {
	return sadd;
}
public void setSadd(String sadd) {
	this.sadd = sadd;
}
@Override
public String toString() {
	return "StudentDTO [no=" + no + ", name=" + name + ", sadd=" + sadd + "]";
}


}
