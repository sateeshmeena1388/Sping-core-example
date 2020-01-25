package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.StudentBO;

public class RegistrationDAO {
private static final String STUD_INSERT_QRY="INSERT INTO STUDENT VALUES(?,?,?)";
private JdbcTemplate jt;
public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}
public boolean insert(List<StudentBO> listbo){
	int result[]=jt.batchUpdate(STUD_INSERT_QRY,new BatchInsertion(listbo));
	if(result!=null)
	return true;
	else
		return false;
}
private static final class BatchInsertion implements BatchPreparedStatementSetter{
	
	List<StudentBO> listbo;

	public BatchInsertion(List<StudentBO> listbo) {
		super();
		this.listbo = listbo;
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		
		System.out.println("getBatchsize");
		return listbo.size();
	
	}

	@Override
	public void setValues(PreparedStatement pst, int index) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Setvalues");
		pst.setInt(1, listbo.get(index).getNo());
		pst.setString(2, listbo.get(index).getName());
		pst.setString(3, listbo.get(index).getSadd());
		
	}
}
}
