package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {
	//���
	boolean addProduct(Product product);
	//�鿴
	List<Product> findAll();
	//�޸�
	boolean updateProduct(Product product);
	//ɾ��
	boolean deleteProduct(int id);
	//����ID�鿴��Ʒ
	Product findProductById(int id);
	//��ҳ��ȡ����
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
}
