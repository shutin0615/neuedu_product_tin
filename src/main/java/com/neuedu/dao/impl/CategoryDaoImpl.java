package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DButils;

public class CategoryDaoImpl implements CategoryDao {

	//���
	public boolean addCategory(Category category) {
		//temp1 ��������
				Connection coon = null;
				PreparedStatement st = null;
				
			
				try {
					System.out.println("�����������");
					coon = DButils.getConnection();
		
					String sql ="insert into category(parent_id,name,status,sort_order,create_time,update_time)values(?,?,?,?,now(),now())";
					System.out.println(sql);
					st = coon.prepareStatement(sql);
					st.setInt(1, category.getParent_id());
					st.setString(2, category.getName());
					st.setInt(3, category.getStatus());
					st.setInt(4, category.getSort_order());
					
							
					st.execute();
					System.out.println("Sql���ִ����ϣ�");
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

			
		return false;
	}

	//�鿴���
	public List<Category> findAll() {
		 List<Category> categorys = new ArrayList<Category>();
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				
				System.out.println("�����������");
				//temp2��ȡ����
				coon = DButils.getConnection();
				//temp3��ȡstatement
				String sql = "select * from category";
				st = coon.prepareStatement(sql);
				
				 rs = st.executeQuery();
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					 	int   id = rs.getInt("id");
						int  parent_id = rs.getInt("parent_id");   
						String name = rs.getString("name");
						int status = rs.getInt("status"); 	//���״̬
						int sort_order = rs.getInt("sort_order");   //������
						String create_time = rs.getString("create_time");
						String update_time = rs.getString("update_time");
					
						Category category = new Category(id,parent_id,name,status,sort_order,create_time,update_time);
						categorys.add(category);
						
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
		
			return categorys;
		
	}

	//�޸�
	public boolean updateCategory(Category category) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			coon = DButils.getConnection();
		
			
			String sql = "update category set parent_id=?,name=?,status=?,sort_order=?,create_time=now(),update_time=now() where id=? ";
			
			st = coon.prepareStatement(sql);
			st.setInt(1,category.getParent_id() );
			st.setString(2, category.getName());
			st.setInt(3,category.getStatus() );
			st.setInt(4,category.getSort_order());
			
			st.setInt(5, category.getId());
			
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

	@Override
	public boolean deleteCategory(int id) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("�����������");
			coon = DButils.getConnection();
			
			
			String sql ="delete from category where id=? ";
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

	@Override
	public Category findCategoryById(int id) {
		Category category = new Category();
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1��������
		try {
			
			System.out.println("�����������");
			//temp2��ȡ����
			coon = DButils.getConnection();
			//temp3��ȡstatement
			String sql = "select * from category where id=?";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			
			 rs = st.executeQuery();
			 System.out.println("sql���ִ�����");
			 if(rs.first()) {
				
				 category.setId(rs.getInt("id"));
				 category.setParent_id((rs.getInt("id")));
				 category.setName(rs.getString("name"));
				 category.setStatus(rs.getInt("status"));
				 category.setSort_order(rs.getInt("sort_order"));
				 category.setCreate_time(rs.getString("create_time"));
				 category.setUpdate_time(rs.getString("update_time"));
				
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
	
		return category;
	}

	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		PageModel<Category> pageModel = new PageModel<Category>();
		
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1��������
		try {
			coon = DButils.getConnection();
			String sqlcount = "select count(id) from category";
			st = coon.prepareStatement(sqlcount);
			rs = st.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);//�ܵ����ݼ�¼��
				//�����м�ҳ
				
				int totalPage = (count%pageSize)==0?count/pageSize:(count/pageSize+1);
				pageModel.setTotalpage(totalPage);
			}
			
			
			System.out.println("�����������");
			//temp2��ȡ����
			
			//temp3��ȡstatement
			String sql = "select * from category limit ?,? ";
			
			st = coon.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize); 
			rs = st.executeQuery();
			List<Category> categorys = new ArrayList<Category>(); 
			 System.out.println("sql���ִ�����");
			 while(rs.next()) {
				 	int   id = rs.getInt("id");
					int  parent_id = rs.getInt("parent_id");   
					String name = rs.getString("name");
					int status = rs.getInt("status"); 	//���״̬
					int sort_order = rs.getInt("sort_order");   //������
					String create_time = rs.getString("create_time");
					String update_time = rs.getString("update_time");
				
					Category cate = new Category(id,parent_id,name,status,sort_order,create_time,update_time);
					categorys.add(cate);
				
			 }
			 pageModel.setData(categorys);
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
