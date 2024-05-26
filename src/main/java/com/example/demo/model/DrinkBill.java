package com.example.demo.model;

public class DrinkBill {

	private int billId, quantity;
	private String productId, address, phone, name, date;
	private Double price;
	
	public DrinkBill() {
		
	}
	
	
	public DrinkBill(int billId, String productId, String name, int quantity, String date, String address, String phone, Double price) {
		this.name = name;
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.date = date;
		this.address = address;
		this.phone = phone;
		this.price = price;
	}


	public DrinkBill(String productId, int quantity, String address, String phone, Double price) {
		this.productId = productId;
		this.quantity = quantity;
		this.address = address;
		this.phone = phone;
		this.price = price;
	}
	
	public DrinkBill(int billId, String productId, int quantity, String address, String phone, Double price) {
		this.billId = billId;
		this.productId = productId;
		this.quantity = quantity;
		this.address = address;
		this.phone = phone;
		this.price = price;
	}
	

	public String getName() {
		return name;
	}



	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "DrinkBill [billId=" + billId + ", quantity=" + quantity + ", productId=" + productId + ", address="
				+ address + ", phone=" + phone + ", name=" + name + ", date=" + date + ", price=" + price + "]";
	}



	
	
	
}
