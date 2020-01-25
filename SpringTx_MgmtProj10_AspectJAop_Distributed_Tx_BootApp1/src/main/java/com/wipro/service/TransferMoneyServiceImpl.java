package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dao.DipositDAO;
import com.wipro.dao.WithdrawDAO;
@Service("bankService")
public class TransferMoneyServiceImpl implements TransferMoneyService {
@Autowired
private WithdrawDAO wDao;
      
@Autowired
private DipositDAO dDao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="dsTxMgmr",readOnly=false,timeout=30)
	public boolean transferMoney(int srcAcc, int desAcc, int amt) {
		int result1=0,result2=0;
		boolean flag=true;
		// TODO Auto-generated method stub
		result1=wDao.withdraw(srcAcc, amt);
		result2=dDao.diposit(desAcc, amt);
		if(result1==0||result2==0)
		{
			flag=false;
			throw new IllegalArgumentException("invalid inputs");
		}
		
		return flag;
	}

}
