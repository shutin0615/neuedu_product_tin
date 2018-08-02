package com.neuedu.service.impl;

import com.neuedu.dao.LoginDao;
import com.neuedu.dao.impl.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.mybatisImplDao.LoginMybatis;
import com.neuedu.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginMybatis();

	public Account LogonLogic(String name, String password) {

		return ld.LogonLogic(name, password);
	}


	public void addToken(Account acc, String token) {
		ld.addToken(acc, token);
	}


	public String findTokenByAccountId(int accountid) {
		
		return ld.findTokenByAccountId(accountid);
	}

}
