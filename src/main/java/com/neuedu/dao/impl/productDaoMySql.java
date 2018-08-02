package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DButils;

public class productDaoMySql implements ProductDao {

	
	
	public boolean addProduct(Product product) {
		//temp1 ????????
		Connection coon = null;
		PreparedStatement st = null;
		
	
		try {
			System.out.println("???????????");
			coon = DButils.getConnection();
			
			String name = product.getName();
			String detail = product.getDetail();
			double price = product.getPrice();
			String image = product.getImage();
			String sql ="insert into product(name,detail,price,image,stock)values(?,?,?,?,?)";
			st = coon.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, detail);
			st.setDouble(3, price);
			st.setString(4,image);
			st.setInt(5, product.getStock());
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
		return true;
	}

	
	
	/*
	 * ??????=============
	 * 
	 * */
	
	
	public List<Product> findAll() {
		 List<Product> products = new ArrayList<Product>();
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1????????
			try {
				
				System.out.println("???????????");
				//temp2???????
				coon = DButils.getConnection();
				//temp3???statement
				String sql = "select * from product";
				st = coon.prepareStatement(sql);
				
				 rs = st.executeQuery();
				 System.out.println("sql?????????");
				 while(rs.next()) {
					int id =  rs.getInt("id");
					String name = rs.getString("name");
					String detail = rs.getString("detail");
					double price = rs.getDouble("price");
					String image = rs.getString("image");
					int stock = rs.getInt("stock");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setDetail(detail);
					product.setPrice(price);
					product.setImage(image);
					product.setStock(stock);
					
					products.add(product);
					
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
		
			return products;
		
	}
	
	
	
	

	/*
	 * ???????
	 * */
	public boolean updateProduct(Product product) {
		
		Connection coon = null;
		PreparedStatement st = null;
		try {
			coon = DButils.getConnection();
			
			
			String name = product.getName();
			String detail = product.getDetail();
			double price = product.getPrice();
			String image = product.getImage();
			
			
			String sql = "update product set name=?,detail=?,price=?,image=?,stock=? where id=? ";
			st = coon.prepareStatement(sql);
			st.setString(1,name );
			st.setString(2, detail);
			st.setDouble(3, price);
			st.setString(4,image);
			st.setInt(5, product.getStock());
			st.setInt(6, product.getId());
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	 * ???????
	 * */
	public boolean deleteProduct(int id) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("???????????");
			coon = DButils.getConnection();
			
			
			String sql ="delete from product where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
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

	//???ID????
	public Product findProductById(int id) {
		
		Product product =new Product();
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1????????
		try {
			
			System.out.println("???????????");
			//temp2???????
			coon = DButils.getConnection();
			//temp3???statement
			String sql = "select * from product where id=?";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			
			 rs = st.executeQuery();
			 System.out.println("sql?????????");
			 if(rs.first()) {
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setDetail(rs.getString("detail"));
					product.setPrice(rs.getDouble("price"));
					product.setImage(rs.getString("image"));	
					product.setStock(rs.getInt("stock"));
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
	
		return product;
	}
	//??????
	public void deletestock(Product product) {
		
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("???????????");
			coon = DButils.getConnection();
			String sql ="update product set stock= ? where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, product.getStock());
			st.setInt(2, product.getId());
			
			st.execute();
			
			
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
		
	}



	//??????
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		PageModel<Product> pageModel = new PageModel<Product>();
		
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1????????
			try {
				coon = DButils.getConnection();
				String sqlcount = "select count(id) from product";
				st = coon.prepareStatement(sqlcount);
				rs = st.executeQuery();
				if(rs.next()) {
					int count = rs.getInt(1);//???????????
					//?????м??
					
					int totalPage = (count%pageSize)==0?count/pageSize:(count/pageSize+1);
					pageModel.setTotalpage(totalPage);
				}
				
				
				
				System.out.println("???????????");
				//temp2???????
				
				//temp3???statement
				String sql = "select * from product limit ?,? ";
				
				st = coon.prepareStatement(sql);
				st.setInt(1, (pageNo-1)*pageSize);
				st.setInt(2, pageSize); 
				rs = st.executeQuery();
				List<Product> products = new ArrayList<Product>(); 
				 System.out.println("sql?????????");
				 while(rs.next()) {
					int id =  rs.getInt("id");
					String name = rs.getString("name");
					String detail = rs.getString("detail");
					double price = rs.getDouble("price");
					String image = rs.getString("image");
					int stock = rs.getInt("stock");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setDetail(detail);
					product.setPrice(price);
					product.setImage(image);
					product.setStock(stock);
					
					products.add(product);
					
				 }
				pageModel.setData(products);
				pageModel.setCurrentPage(pageNo);
				
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
		
			return pageModel;
		
		
	}
	
	
}
