package com.neuedu.text;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;

import com.neuedu.entity.Product;
import com.neuedu.mybatisImplDao.CartMybatis;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class carttext {
         CartDao dao=null;
    @Before
    public void before(){
        dao=new CartMybatis();
    }

    @Test
    public  void  addCart() {

        Cart cart=new Cart();
        Product product=new Product(3,"33","xiaomi",111,"111",1000);
        cart.setProduct(product);
        cart.setNum(10);
        dao.addCart(cart);


        System.out.println(dao.findCart());
    }

    @After
    public void After(){

    }

}
