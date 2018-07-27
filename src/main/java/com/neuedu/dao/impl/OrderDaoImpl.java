package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DButils;

public class OrderDaoImpl implements OrderDao {

	// ��Ӷ���
	public boolean createOrder(UserOrder order) {

		Connection coon = null;
		Statement st = null;
		
	
		try {
			System.out.println("�����������");
			coon = DButils.getConnection();
			st = coon.createStatement();
	
			String sql ="insert into userorder(order_no,userid,create_time,payment)values("+order.getOrder_no()+","+order.getUser_id()+",now(),"+order.getPayment()+")";
			
			st.execute(sql);
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DButils.close(coon, st);
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	//temp3��ȡstatement �������ִ�з���

		return true;
	}

	
	

	

	
	

	// �鿴����
	public List<UserOrder> findOrder() {
		 List<UserOrder> orders = new ArrayList<UserOrder>();
			Connection coon = null;
			Statement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				
				System.out.println("�����������");
				//temp2��ȡ����
				coon = DButils.getConnection();
				//temp3��ȡstatement
				st = coon.createStatement();
				String sql = "select * from userorder";
				 rs = st.executeQuery(sql);
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					
					int id = rs.getInt("id");
					long order_no = rs.getLong("order_no");
					int user_id = rs.getInt("userid");
					long create_time = rs.getLong("create_time");
					double payment = rs.getDouble("payment");
					UserOrder order = new UserOrder(id,order_no,user_id,create_time,payment);
					orders.add(order);
					
					
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
		
			return orders;
	}

	// ��ȡ����id
	public int getOrderId() {
		
		return 0;

		
	}

}
