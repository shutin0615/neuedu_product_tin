package com.neuedu.dao;

import com.neuedu.entity.Account;

public interface LoginDao {

	public Account LogonLogic(String name, String password);

	public void addToken(Account acc, String token);
	
	public String findTokenByAccountId(int accountid);
}
