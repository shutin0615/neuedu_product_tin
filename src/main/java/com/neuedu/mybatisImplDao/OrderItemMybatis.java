package com.neuedu.mybatisImplDao;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.impl.OrderItemDaoImpl;
import com.neuedu.entity.UserOrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class OrderItemMybatis implements OrderItemDao {
    @Override
    public boolean addOrderItem(List<UserOrderItem> orderItem) {
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
        OrderItemDao orderItemDao=session.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItem(orderItem);
        session.close();
        return false;
    }

    @Override
    public List<UserOrderItem> findOrderItem() {
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

        /*List<UserOrderItem> userOrderItems=session.selectList("com.neuedu.entity.UserOrderItem.findOrderItem");*/
        OrderItemDao orderItemDao=session.getMapper(OrderItemDao.class);
        List<UserOrderItem> orders= orderItemDao.findOrderItem();
        System.out.println(orders);
        session.close();
        return orders;
    }


    @Override
    public int getOrderItemId() {
        return 0;
    }
}
