package com.wipro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("withdDao")
public class WithdrawDAOImpl implements WithdrawDAO {
	private static final String WITHDRAW_QRY="Update DTX_Account Set Balance=Balance-? Where AccNO=?";
	private int count=0;
@Autowired
@Qualifier("oraTemplate") 
	private JdbcTemplate jt;
	

	@Override
	
	public int withdraw(int accNO, int amt) {
		// TODO Auto-generated method stub
		count=jt.update(WITHDRAW_QRY,amt, accNO);
		
		return count;
	}

}
