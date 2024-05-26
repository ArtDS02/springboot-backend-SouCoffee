package com.example.demo.model;

public class OrderDetail {
	private int orderId, orderDetailId;
	private String BoxId, DrinkId, DecorId, Note, Phone;
	private Double price;
	
	
	
	public OrderDetail() {
	}

	public OrderDetail(int orderDetailId, int orderId, String boxId, String drinkId, String decorId, String note,
			String phone, Double price) {
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		BoxId = boxId;
		DrinkId = drinkId;
		DecorId = decorId;
		Note = note;
		Phone = phone;
		this.price = price;
	}
	
	public OrderDetail(int orderId, String boxId, String drinkId, String decorId, String note, String phone, double price) {
        this.orderId = orderId;
        this.BoxId = boxId;
        this.DrinkId = drinkId;
        this.DecorId = decorId;
        this.Note = note;
        this.Phone = phone;
        this.price = price;
    }

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getBoxId() {
		return BoxId;
	}

	public void setBoxId(String boxId) {
		BoxId = boxId;
	}

	public String getDrinkId() {
		return DrinkId;
	}

	public void setDrinkId(String drinkId) {
		DrinkId = drinkId;
	}

	public String getDecorId() {
		return DecorId;
	}

	public void setDecorId(String decorId) {
		DecorId = decorId;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", BoxId=" + BoxId
				+ ", DrinkId=" + DrinkId + ", DecorId=" + DecorId + ", Note=" + Note + ", Phone=" + Phone + ", price="
				+ price + "]";
	}
	
	
	
	
}
