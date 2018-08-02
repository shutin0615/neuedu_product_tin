package com.neuedu.mybatisImplDao;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CategoryMybatis implements CategoryDao{
    @Override
    public boolean addCategory(Category category) {
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
        int a=session.insert("com.neuedu.entity.Category.addProduct",category);
        if(a==1){
            System.out.println("Success");
            session.close();
            return true;
        }else{
            System.out.println("fail");
            session.close();
            return false;
        }

    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        return false;
    }

    @Override
    public Category findCategoryById(int id) {
        return null;
    }

    @Override
    public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
        return null;
    }
}
