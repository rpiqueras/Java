package org.sistema.spring.mq;

import java.io.Serializable;

public class Order implements Serializable{

	private String product;
	private int qty;
	
	public Order() {
	}

	public Order(String product, int qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Order [product=" + product + ", qty=" + qty + "]";
	}
}
