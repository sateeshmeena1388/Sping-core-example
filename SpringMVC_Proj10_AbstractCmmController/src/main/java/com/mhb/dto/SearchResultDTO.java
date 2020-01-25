package com.mhb.dto;

import java.io.Serializable;

public class SearchResultDTO extends SearchDTO implements Serializable {
private int deptNo;
private int mgrNo;
public int getDeptNo() {
	return deptNo;
}
public void setDeptNo(int deptNo) {
	this.deptNo = deptNo;
}
public int getMgrNo() {
	return mgrNo;
}
public void setMgrNo(int mgrNo) {
	this.mgrNo = mgrNo;
}

}
