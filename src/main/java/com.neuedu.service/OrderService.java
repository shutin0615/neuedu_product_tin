package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

public interface OrderService {

	// 创建订单
	boolean createOrder();

	// 查看订单
	List<UserOrder> findOrder();

	List<UserOrderItem> findOrderItem();

	// 获取订单号
	long orderNo();
}
