package com.neuedu.entity;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6420732982998980008L;
	private int id;
	private String name;
	private String detail;
	private double price;
	private String image;
	private int stock;

	
	public Product(String name, String detail, double price, String image, int stock) {
		super();
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;
		this.stock = stock;
	}

	public Product(int id, String name, String detail, double price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;

	}

	public Product( String name, String detail, double price, String image) {
		super();
		
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;

	}
	
	
	public Product(int id, String name, String detail, double price, String image, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;
		this.stock = stock;
	}

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", detail=" + detail + ", price=" + price + ", image=" + image
				+ ", stock=" + stock + "]";
	}

}
