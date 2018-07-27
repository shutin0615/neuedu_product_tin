package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.dao.LoginDao;
import com.neuedu.entity.Account;
import com.neuedu.entity.Product;
import com.neuedu.utils.DButils;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Account LogonLogic(String name, String password) {
		
		Account acc = null;
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1????????
		try {
			
			System.out.println("???????????");
			//temp2???????
			coon = DButils.getConnection();
			//temp3???statement
			String sql = "select * from account where username=? and  password=? ";
			
			st = coon.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2,password);
			st.executeQuery();
			rs = st.executeQuery();
			 System.out.println("sql?????????");
				if(rs.first()) {
					int id = rs.getInt("accountid");
					String _username = rs.getString("username");
					String _password = rs.getString("password");
					acc = new Account(id, _username, _password);
					return acc;
					
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				DButils.close(coon, st, rs);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}	
		}
	
		return null;
	
	
	}

	//???token
	public void addToken(Account acc, String token) {
		//temp1 ????????
				Connection coon = null;
				PreparedStatement st = null;
							
				try {
					System.out.println("???????????");
					coon = DButils.getConnection();
														
					String sql ="update account set token=? where accountid=?";
					
					st = coon.prepareStatement(sql);
					st.setString(1, token);
					st.setInt(2, acc.getId());
					
					st.execute();
					System.out.println("Sql??????????");
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					try {
						DButils.close(coon, st);
					
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			
				
		
	}

	//???token
	public String findTokenByAccountId(int accountid) {
		
	
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1????????
		try {
			
			System.out.println("???????????");
			//temp2???????
			coon = DButils.getConnection();
			//temp3???statement
			String sql = "select token from account where accountid=?";
			System.out.println(sql);
			st = coon.prepareStatement(sql);
			st.setInt(1, accountid);
			
			rs = st.executeQuery();
			System.out.println("sql?????????");
			if(rs.first()) {
					String token = rs.getString("token");
					return token;
				}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				DButils.close(coon, st, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return null;
		
		
		
	}
	

	
	
}
