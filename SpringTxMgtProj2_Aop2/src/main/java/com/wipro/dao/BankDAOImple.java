package com.wipro.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImple implements BankDAO {
	private JdbcTemplate jt;
	private static final String WITHDRAW_QRY ="update tx_account set amt=amt-? where accno=?";
	private static final String DEPOSIT_QRY = "update tx_account set amt=amt+? where accno=?";

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int withdraw(int acno, int amt) {
		// TODO Auto-generated method stub
		int cnt = jt.update(WITHDRAW_QRY, amt, acno);
		return cnt;
	}

	@Override
	public int deposit(int acno, int amt) {
		// TODO Auto-generated method stub
		int cnt = jt.update(DEPOSIT_QRY, amt, acno);
		return cnt;
	}

}
