package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;

public interface OrderItemDao {

	// 把订单明细（订单明细对应一条条商品，应该是集合）加入订单明细集合中
	boolean addOrderItem(List<UserOrderItem> orderItem);

	List<UserOrderItem> findOrderItem();

	int getOrderItemId();
}
