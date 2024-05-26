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
import com.example.demo.model.Orders;


@RestController
@RequestMapping("/Order")
public class OrdersController {

	@GetMapping
	public ArrayList<Orders> getProduct(){
		return OrderDao.showAllOrder();
	}
	
	@GetMapping("/{id}")
	public ArrayList<Orders> getProductbyId(@PathVariable("id") String id){
		return OrderDao.getOrderById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrders(@PathVariable("id") int id) {
		System.out.println("Bat dau xoa:"+ id);
	    OrderDao.deleteOrder(id);
	}
	
	@PostMapping
	public Orders addNewOrder(@RequestBody Orders newOrder) {
		try {
			Orders insertedOrder = OrderDao.insertAndGetOrder(newOrder.getDate(), newOrder.getStatus(), newOrder.getAddress(), newOrder.getPrice());
	        return insertedOrder;
		} catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@PutMapping("/{id}")
	public String updateOrders(@PathVariable("id") int id, @RequestBody Orders updatedOrder) {
		try {
			OrderDao.updateOrder(id, updatedOrder.getDate(), updatedOrder.getStatus(), updatedOrder.getAddress(), updatedOrder.getPrice());
			System.out.println("Bat dau update:"+ id);
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
	}
}
