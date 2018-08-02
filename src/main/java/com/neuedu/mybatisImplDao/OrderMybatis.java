package com.neuedu.mybatisImplDao;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OrderMybatis implements OrderDao{
    @Override
    public boolean createOrder(UserOrder order) {
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
        OrderDao orderDao=session.getMapper(OrderDao.class);
        orderDao.createOrder(order);
        session.close();
        return true;
    }

    @Override
    public List<UserOrder> findOrder() {
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
        OrderDao orderDao=session.getMapper(OrderDao.class);
        List<UserOrder> orders=orderDao.findOrder();
        session.close();
        return orders;
    }

    @Override
    public int getOrderId() {
        return 0;
    }
}





