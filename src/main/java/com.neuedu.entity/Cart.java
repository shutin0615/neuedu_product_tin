package com.neuedu.entity;

import java.io.Serializable;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3340604346152912765L;
	private int id;
	private Product product;
	private int num;
	private int productid;

	public Cart(int id, Product product, int num) {
		super();
		this.id = id;
		this.product = product;
		this.num = num;
	}

	public Cart() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", num=" + num + ", productid=" + productid + "]";
	}


	
}
