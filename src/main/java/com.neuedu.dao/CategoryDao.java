package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CategoryDao {

		//���
		boolean addCategory(Category category);
		//�鿴
		List<Category> findAll();
		//�޸�
		boolean updateCategory(Category category);
		//ɾ��
		boolean deleteCategory(int id);
		//����ID�鿴ĳ�����
		Category findCategoryById(int id);
		//��ҳ��ȡ����
		PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
}
