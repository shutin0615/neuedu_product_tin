package com.neuedu.mybatisImplDao;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class productDaoImpl implements ProductDao{
    @Override
    public boolean addProduct(Product product) {
       String resource="mybatis-config.xml";
       Reader reader=null;
       SqlSession session;
        try {
            reader= Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession(true);
        int a=session.insert("com.neuedu.entity.Product.addProduct",product);
        if(a==1){
            System.out.println("添加成功");
            session.close();
            return true;
        }else{
            System.out.println("添加失败");
            session.close();
            return false;
        }

    }

    @Override
    public List<Product> findAll() {
        String resource="mybatis-config.xml";
        Reader reader=null;
        SqlSession session;

        try {
            reader= Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
          session=sqlMapper.openSession();
          List<Product> products=session.selectList("com.neuedu.entity.Product.findProduct");
        System.out.println(products);
        session.close();
        return products;
    }

    @Override
    public boolean updateProduct(Product product) {
           String resource="mybatis-config.xml";
           Reader reader=null;
           SqlSession session;
        try {
            reader=Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
     SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
            session=sqlMapper.openSession(true);
            int u=session.update("com.neuedu.entity.Product.updateProduct",product);
            if (u==1){
                System.out.println("修改成功");
                session.close();
                return true;
            }else{
                System.out.println("修改失败");
                session.close();
                return false;
            }
    }
    @Override
    public boolean deleteProduct(int id) {
        String resource="mybatis-config.xml";
        Reader reader=null;
        SqlSession session;
        try {
            reader=Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession(true);
        int d=session.update("com.neuedu.entity.Product.deleteProduct",id);
        if(d==1){
            System.out.println("删除成功");
            session.close();
            return  true;
        }else {
            System.out.println("删除失败");
            session.close();
            return false;
        }
    }

    @Override
    public Product findProductById(int id) {
        String resource="mybatis-config.xml";
        Reader reader=null;
        SqlSession session;
        try {
            reader=Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();
        Product product=session.selectOne("com.neuedu.entity.Product.findProudctById",id);
       session.close();
        return product;
    }

    @Override
    public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
        return null;
    }
}
