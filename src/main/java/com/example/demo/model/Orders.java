package com.example.demo.model;

public class Orders {
	private int orderId;
	private String date, status, address;
	private Double price;
	
	
	public Orders() {
	
	}

	public Orders(int orderId, String date, String status, String address, Double price) {
		this.orderId = orderId;
		this.date = date;
		this.status = status;
		this.address = address;
		this.price = price;
	}
	
	public Orders(String date, String status, String address, Double price) {
		this.date = date;
		this.status = status;
		this.address = address;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", date=" + date + ", status=" + status + ", address=" + address
				+ ", price=" + price + "]";
	}
	
	
	

}
