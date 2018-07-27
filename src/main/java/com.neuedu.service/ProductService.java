package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	// ���
	boolean addProduct(Product product);

	// �鿴
	List<Product> findAll();

	// �޸�
	boolean updateProduct(Product product);

	// ɾ��
	boolean deleteProduct(int id);

	// ���ݣɣķ�����Ʒ
	Product findProductById(int id);
	
	//��ҳ��ѯ
	PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
}
