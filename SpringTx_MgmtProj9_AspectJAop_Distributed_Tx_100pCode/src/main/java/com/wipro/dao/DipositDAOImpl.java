package com.wipro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("dipoDao")
public class DipositDAOImpl implements DipositDAO {
private static final String DIPOSIT_QRY="Update DTX_Account Set Balance=Balance+? Where AccNO=?";
 int count=0;	
@Autowired
	@Qualifier("mysqlTemplate")
private JdbcTemplate jt;

@Override

	public int diposit(int accNO, int amt) {
		// TODO Auto-generated method stub
	count=jt.update(DIPOSIT_QRY,amt,accNO);
		return count;
	}

}
