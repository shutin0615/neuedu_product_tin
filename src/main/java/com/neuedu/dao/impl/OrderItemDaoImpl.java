package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DButils;

public class OrderItemDaoImpl implements OrderItemDao {

	/* ��Ӷ�����ϸ */
	public boolean addOrderItem(List<UserOrderItem> orderItem) {
		
		Connection coon = null;
		Statement st = null;

		try {
			System.out.println("�����������");
			coon = DButils.getConnection();
			st = coon.createStatement();
	
		
			String sql = "insert into userorderitem (order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time,update_time)values";
			StringBuffer sbuffer = new StringBuffer(sql);
			for(int i=0;i<orderItem.size();i++) {
				UserOrderItem item = orderItem.get(i);
				sbuffer.append("(");
				
				sbuffer.append(item.getOrder_no()+",");
				sbuffer.append(item.getUser_id()+",");
				sbuffer.append(item.getProduct_id()+",");
				sbuffer.append("'"+item.getProduct_name()+"',");
				sbuffer.append("'"+item.getProduct_image()+"',");
				sbuffer.append(item.getCurrent_unit_price()+",");
				sbuffer.append(item.getQuantity()+",");
				sbuffer.append(item.getTotal_price()+",");
				sbuffer.append("now()"+",");
				sbuffer.append("now()");
		
				sbuffer.append(")");
				
				if(i!=orderItem.size()-1) {
					sbuffer.append(",");
				}
			}
			
			
			st.execute(sbuffer.toString());
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
	

		return false;

		

		
	}

	/* �鿴������ϸ */
	public List<UserOrderItem> findOrderItem() {
		 List<UserOrderItem> items = new ArrayList<UserOrderItem>();
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
				String sql = "select * from userorderitem";
				 rs = st.executeQuery(sql);
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
	
					 
					     int id = rs.getInt("id"); // ������ϸID
						 long order_no = rs.getLong("order_no");// �Ͷ������һ��
						 int user_id = rs.getInt("user_id");// �û�id
						 int product_id = rs.getInt("product_id");// ��Ʒid
						 String product_name = rs.getString("product_name");// ��Ʒ����
						 String product_image = rs.getString("product_image");// ��ƷͼƬ
						 double current_unit_price = rs.getDouble("current_unit_price");// ���ɶ���ʱ�ļ۸�
						 int quantity = rs.getInt("quantity");// ��Ʒ����
						 double total_price = rs.getDouble("total_price"); // �ܼ�
						 long create_time = rs.getLong("create_time");// ����ʱ��
						 long update_time = rs.getLong("update_time");// ����ʱ��
					UserOrderItem item = new UserOrderItem(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time,update_time);
					items.add(item);
								
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
		
			return items;

		
	}

	@Override
	public int getOrderItemId() {
		return 0;

		
	}

}
