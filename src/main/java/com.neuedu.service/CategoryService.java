package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

public interface CategoryService {

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
