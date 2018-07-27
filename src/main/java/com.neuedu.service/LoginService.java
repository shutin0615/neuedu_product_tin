package com.neuedu.service;

import com.neuedu.entity.Account;

public interface LoginService {

	public Account LogonLogic(String name, String password);
	
	public void addToken(Account acc, String token);
	
	public String findTokenByAccountId(int accountid);
}
