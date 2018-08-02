package com.neuedu.mybatisImplDao;

import org.apache.ibatis.io.Resources;
import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CartMybatis implements CartDao{



    @Override
    public boolean addCart(Cart cart) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession(true);

        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.addCart(cart);
        session.close();
        return false;
    }


    @Override
    public List<Cart> findCart() {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();

        CartDao cartDao=session.getMapper(CartDao.class);
        List<Cart> cart= cartDao.findCart();
        session.close();
        return cart;

       /* List<Cart> cart=session.selectList("com.neuedu.entity.Cart.findCart");
        System.out.println(cart);
        session.close();
        return cart;*/
    }


    @Override
    public boolean updateCart(Cart cart) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession();

        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.updateCart(cart);
        session.commit();
        session.close();
        return true;

    }

    @Override
    public boolean deleteCart(int id) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession(true);
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.deleteCart(id);
        session.close();
        return true;

    }

    @Override
    public int getOrderId() {
        return 0;
    }

    @Override
    public Cart getCartById(int id) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
        session = sqlMapper.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        Cart cart= cartDao.getCartById(id);
        session.commit();
        session.close();
        return cart;
    }

    @Override
    public void clearCart() {

        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        session=sqlMapper.openSession(true);
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.clearCart();
        session.close();

    }
}
