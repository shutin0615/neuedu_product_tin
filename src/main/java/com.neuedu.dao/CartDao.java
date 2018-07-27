package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartDao {

	boolean addCart(Cart cart);//Ôö
	
	List<Cart> findCart();//²é
	
	boolean updateCart(Cart cart);//¸Ä
	
	boolean deleteCart(int id);//É¾
	
	int getOrderId();
	
	Cart getCartById(int id);
	
	void clearCart();
}
