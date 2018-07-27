package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.CartDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cd = new CartDaoImpl();

	@Override
	public boolean addCart(Cart cart) {

		return cd.addCart(cart);
	}

	@Override
	public List<Cart> findCart() {

		return cd.findCart();
	}

	@Override
	public boolean updateCart(Cart cart) {

		return cd.updateCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {

		return cd.deleteCart(id);
	}

	@Override
	public int getOrderId() {

		return cd.getOrderId();
	}

	@Override
	public Cart getCartById(int id) {

		return cd.getCartById(id);
	}

}
