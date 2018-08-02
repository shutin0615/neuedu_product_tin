package com.neuedu.text;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;
import com.neuedu.mybatisImplDao.productDaoImpl;
import org.junit.Test;

public class producttext {

    @Test
    public  void textfindAll(){
        ProductDao dao=new productDaoImpl();
        dao.findAll();
    }
    @Test
    public  void textAddProduct(){
        ProductDao dao=new productDaoImpl();
        Product product=new Product("香水1","111",111,"1",20);
        dao.addProduct(product);
    }

    @Test
    public  void textupdateProduct(){
        ProductDao dao=new productDaoImpl();
        Product product=new Product(1,"香","111",111,"1",20);
        dao.updateProduct(product);
    }

    @Test
    public  void textdeleteProduct(){
        ProductDao dao=new productDaoImpl();
        dao.deleteProduct(1);
    }
    @Test
  public void textfindProductById(){
      ProductDao dao=new productDaoImpl();

        System.out.println(dao.findProductById(2));
  }

}
