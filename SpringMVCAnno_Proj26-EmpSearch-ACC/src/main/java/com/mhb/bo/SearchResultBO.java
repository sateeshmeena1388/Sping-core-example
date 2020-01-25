package com.mhb.bo;

public class SearchResultBO extends SearchBO {
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
		return "SearchResultBO [deptno=" + deptno + ", mgrNo=" + mgrNo + ", getEno()=" + getEno() + ", getEname()="
				+ getEname() + ", getJob()=" + getJob() + ", getSalary()=" + getSalary() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
