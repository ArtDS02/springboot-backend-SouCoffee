package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OrderDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;


@RestController
@RequestMapping("/Product")
public class ProductController {

	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello world";
	}
	
	@GetMapping
	public ArrayList<Product> getProduct(){
		return ProductDao.showAllProduct();
	}
	
	@PostMapping
	public void addNewProduct(@RequestBody Product newProduct) {
		try {
			ProductDao.insertProduct(newProduct.getId(), newProduct.getName(), newProduct.getPrice(), newProduct.getDescription(), newProduct.getImage());
			System.out.println("Success"+ newProduct.toString());
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") String id) {
	    ProductDao.deleteProduct(id);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable("id") String id, @RequestBody Product updatedProduct) {
		try {
			ProductDao.updateProduct(id, updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getDescription(), updatedProduct.getImage());
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
	}
}
