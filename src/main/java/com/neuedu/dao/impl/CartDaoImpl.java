package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;

import com.neuedu.dao.impl.productDaoMySql;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.utils.DButils;

public class CartDaoImpl implements CartDao {

	//���빺�ﳵ
	public boolean addCart(Cart cart) {
		Connection coon = null;
		PreparedStatement st = null;
		
		//��ȡ����
		try {
			coon = DButils.getConnection();
			
			int productid = cart.getProduct().getId();
			int productnum = cart.getNum();

			String sql = "insert into cart(productid,num)values(?,?)";
			st = coon.prepareStatement(sql);
			st.setInt(1, productid);
			st.setInt(2, productnum);
					
			st.execute();
			
			return true;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DButils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return false;
	}

	/*
	 * �鿴���ﳵ
	 * */
	public List<Cart> findCart() {
		ProductDao pd = new productDaoMySql();
		
		List<Cart> carts = new ArrayList<Cart>();
		Connection coon = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			coon = DButils.getConnection();
			st = coon.createStatement();
			String sql = "select * from cart";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
		
				int productid = rs.getInt("productid");
				Product product = pd.findProductById(productid);
				Cart cart = new Cart();
				cart.setProductid(productid);
				cart.setId(rs.getInt("id"));
				cart.setProduct(product);
				cart.setNum(rs.getInt("num"));
				
				carts.add(cart);
					
			}
			
		} catch (SQLException e) {
			try {
				DButils.close(coon, st, rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return carts;
	}
	
	

	/*
	 * �޸Ĺ��ﳵ��Ʒ����
	 * */
	public boolean updateCart(Cart cart) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			coon = DButils.getConnection();
			String sql = "update cart set productnum=? where id=?";
			st = coon.prepareStatement(sql);
			st.setInt(1, cart.getNum());
			st.setInt(2, cart.getId());
				
			st.execute();
			return true;	
		
		} catch (SQLException e) {
			try {
				DButils.close(coon, st);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return false;
	}

	/*
	 * ɾ�����ﳵ
	 * */
	public boolean deleteCart(int id) {
		Connection coon = null;
		Statement st = null;
		try {
			coon = DButils.getConnection();
			st = coon.createStatement();
			
			String sql = "delete from cart where id="+id+"";
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			try {
				DButils.close(coon, st);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		return false;
		
		
	}

	
	public int getOrderId() {
		return 0;
		
		
	}

	//ͨ��ID���ҵ�������ﳵ
	public Cart getCartById(int id) {
		
		Connection coon = null;
		Statement st = null;
		ResultSet rs = null;
		
		Cart cart = null;
		try {
			coon = DButils.getConnection();
			st = coon.createStatement();
			String sql = "select * from cart";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(id==rs.getInt("id")) {
					cart = new Cart();
					int _id = rs.getInt("id");
					int num = rs.getInt("num");
					cart.setId(_id);
					cart.setNum(num);
					
				}
			}
			
			
		} catch (SQLException e) {
			try {
				DButils.close(coon, st, rs);
			}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
		return cart;
		
		
	}

	@Override
	public void clearCart() {
		Connection coon = null;
		Statement st = null;
		try {
			coon = DButils.getConnection();
			st = coon.createStatement();
			
			String sql = "delete from cart";
			st.execute(sql);
		
		} catch (SQLException e) {
			try {
				DButils.close(coon, st);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
