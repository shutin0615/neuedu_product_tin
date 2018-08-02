package com.neuedu.text;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.mybatisImplDao.CartMybatis;
import com.neuedu.mybatisImplDao.OrderMybatis;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ordertext {

    OrderService orderService=null;
    @Before
    public void before(){
      orderService=new OrderServiceImpl();
    }

@Test
    public  void  textOrder(){

        orderService.createOrder();

    }

    @After
    public void After(){
 orderService=null;
    }




}
