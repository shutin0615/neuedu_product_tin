package com.neuedu.entity;

import java.io.Serializable;

public class UserOrderItem implements Serializable {

	private int id; // 订单明细ID
	private long order_no;// 和订单编号一样
	private int user_id;// 用户id
	private int product_id;// 商品id
	private String product_name;// 商品名字
	private String product_image;// 商品图片

	public UserOrderItem(int id, int user_id, int product_id, String product_name, String product_image, int quantity, long create_time, long update_time) {
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.quantity = quantity;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	private double current_unit_price;// 生成订单时的价格
	private int quantity;// 商品数量
	private double total_price; // 总价
	private long create_time;// 创建时间
	private long update_time;// 更新时间

	public UserOrderItem(int id, long order_no, int user_id, int product_id, String product_name, String product_image,
			double current_unit_price, int quantity, double total_price, long create_time, long update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public UserOrderItem() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOrder_no() {
		return order_no;
	}

	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public double getCurrent_unit_price() {
		return current_unit_price;
	}

	public void setCurrent_unit_price(double current_unit_price) {
		this.current_unit_price = current_unit_price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public long getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "UserOrderItem [订单明细id：" + id + ", 订单编号：" + order_no + ", user_id=" + user_id + ", 商品id：" + product_id
				+ ", 商品名字：" + product_name + ", 商品图片" + product_image + ",生成订单时的价格：" + current_unit_price + ", 商品数量"
				+ quantity + ", 商品总价：" + total_price + ", 创建时间：" + create_time + ", 更新时间：" + update_time + "]";
	}

}
