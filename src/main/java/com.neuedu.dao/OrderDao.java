package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrder;

public interface OrderDao {

	// 创建订单
	boolean createOrder(UserOrder order);

	// 查看订单
	List<UserOrder> findOrder();

	// 获取订单ID
	int getOrderId();
}
