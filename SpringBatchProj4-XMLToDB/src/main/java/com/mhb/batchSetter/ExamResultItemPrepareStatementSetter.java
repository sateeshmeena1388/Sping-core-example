package com.mhb.batchSetter;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mhb.model.ExamResult;

public class ExamResultItemPrepareStatementSetter implements ItemPreparedStatementSetter<ExamResult> {

	

	@Override
	public void setValues(ExamResult result, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(1, result.getId());
		ps.setInt(2, result.getSem());
		ps.setDate(3, result.getDob());
		ps.setDouble(4, result.getPercentage());
		
	}

}
