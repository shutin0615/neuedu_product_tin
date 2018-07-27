package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.productDaoMySql;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;

public class ProductServiceImplSql implements ProductService {

	ProductDao pd = new productDaoMySql();
	
	public boolean addProduct(Product product) {
		
		return pd.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		
		return  pd.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
	
		return pd.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
	
		return pd.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		
		return pd.findProductById(id);
	}

	//∑÷“≥≤È—Ø
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		
		return pd.findProductByPage(pageNo, pageSize);
	}

}
