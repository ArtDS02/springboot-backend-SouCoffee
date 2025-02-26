package com.example.demo.model;

public class Product {

	private String id, name, image, description;
	private double price;
	
	public Product() {
		
	}
	public Product(String id, String name, double price, String description, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name +  ", price=" + price + ", description=" + description 
				+ ", image=" + image + "]";
	}
	
	
	
	
	
	
}
