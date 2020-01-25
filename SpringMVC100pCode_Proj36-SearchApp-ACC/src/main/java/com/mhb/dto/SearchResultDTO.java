package com.mhb.dto;

import java.io.Serializable;

public class SearchResultDTO extends SearchDTO implements  Serializable{
  private int deptno;
  private int mgrNo;
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public int getMgrNo() {
	return mgrNo;
}
public void setMgrNo(int mgrNo) {
	this.mgrNo = mgrNo;
}
@Override
public String toString() {
	return "SearchResultDTO [deptno=" + deptno + ", mgrNo=" + mgrNo + ", getEno()=" + getEno() + ", getEname()="
			+ getEname() + ", getJob()=" + getJob() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}


}
