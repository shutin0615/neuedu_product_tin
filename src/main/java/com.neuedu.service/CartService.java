package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;

public interface CartService {

	boolean addCart(Cart cart);// Ôö

	List<Cart> findCart();// ²é

	boolean updateCart(Cart cart);// ¸Ä

	boolean deleteCart(int id);// É¾

	public int getOrderId();

	Cart getCartById(int id);
}
