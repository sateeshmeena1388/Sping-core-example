package com.mhb.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mhb.batch.ExamResult;

public class ExamResultMapper implements RowMapper<ExamResult> {

	@Override
	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ExamResult result=null;
		result=new ExamResult();
		result.setId(rs.getInt("ID"));
		result.setSem(rs.getInt("Semester"));
		result.setDob(rs.getDate("Dob"));
		result.setPercentage(rs.getDouble("Percentage"));
		System.out.println("Result" +result.toString());
		return result;
	
	}

}
