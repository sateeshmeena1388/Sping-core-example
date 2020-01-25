package com.wipro.service;

import com.wipro.dao.BankDAO;

public class BankServiceImple implements BankService {
private BankDAO dao;
	public void setDao(BankDAO dao) {
	this.dao = dao;
}
	@Override
	public boolean transferMoney(int srcNo, int desNO, int amt) {
		// TODO Auto-generated method stub
		int result1=dao.withdraw(srcNo, amt);
		int result2=dao.deposit(desNO, amt);
		if(result1==0|| result2==0)
			throw new RuntimeException("Money not Transfer(Tx RollBack");
		else
			System.out.println("Money Transfer(Tx Commited)");
		return true;
	}

}
