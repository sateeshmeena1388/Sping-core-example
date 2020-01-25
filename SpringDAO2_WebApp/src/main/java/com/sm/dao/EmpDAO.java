package com.sm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDAO {
private JdbcTemplate jt;

public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}
public List<Map<String,Object>> getEmpdetails(String condition){
List<Map<String,Object>> list=jt.queryForList(
"SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+condition+" ORDER BY JOB", new Object[]{});
return list;

      }
}
