package com.neuedu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButils {

	static Properties ps = new Properties();
	
	static {
		
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("shop.properties"));
			Class.forName(ps.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	//获取连接
	public static Connection getConnection() throws SQLException {
		String url = ps.getProperty("url");
		String username = ps.getProperty("username");
		String password = ps.getProperty("password");
		return DriverManager.getConnection(url, username, password);
		
	}
	
	//关闭资源
	public static void close(Connection coon,Statement st) throws SQLException {
		if(coon!=null) {
			coon.close();
		}
		if(st!=null) {
			st.close();
		}
		
	}
	
	public static void close(Connection coon,Statement st,ResultSet rs) throws SQLException {
		if(coon!=null) {
			coon.close();
		}
		if(st!=null) {
			st.close();
		}
		if(rs!=null) {
			rs.close();
		}
		
	}
	
	
}
