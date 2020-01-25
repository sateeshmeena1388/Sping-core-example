package com.nt.bo;

public class StudentBO {
	private int no;
private String name;
private String sadd;
public StudentBO() {
	System.out.println("StudentBO");
	// TODO Auto-generated constructor s
}

public StudentBO(int no, String name, String sadd) {
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


}