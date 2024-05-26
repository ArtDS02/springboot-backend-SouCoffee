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
import com.example.demo.dao.OrderDetailDao;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Orders;


@RestController
@RequestMapping("/OrderDetail")
public class OrderDetailController {

	@GetMapping
	public ArrayList<OrderDetail> getOrderDetail(){
		return OrderDetailDao.showAllOrderDetail();
	}
	
	@GetMapping("/{id}")
	public ArrayList<OrderDetail> getOrderDetailbyId(@PathVariable("id") String id){
		return OrderDetailDao.getOrderDetailById(id);
	}
	
	@PostMapping
    public String addNewOrderDetail(@RequestBody OrderDetail newOrderDetail) {
        try {
            System.out.println("Bat dau:");
            System.out.println(newOrderDetail);
            OrderDetailDao.insertOrderDetail(newOrderDetail.getOrderId(), newOrderDetail.getBoxId(), newOrderDetail.getDrinkId(), newOrderDetail.getDecorId(), newOrderDetail.getNote(), newOrderDetail.getPhone(), newOrderDetail.getPrice());
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }
	
	@DeleteMapping("/{id}")
	public void deleteOrderDetail(@PathVariable("id") int id) {
		System.out.println("Bat dau xoa:"+ id);
		OrderDetailDao.deleteOrderDetail(id);
	}
	
	@PutMapping("/{id}")
	public String updateOrderDetail(@PathVariable("id") int id, @RequestBody OrderDetail updatedOrder) {
		try {
			OrderDetailDao.updateOrderDetail(id, updatedOrder.getBoxId(), updatedOrder.getDrinkId(), updatedOrder.getDecorId(), updatedOrder.getNote(), updatedOrder.getPhone() ,updatedOrder.getPrice());
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
	}
}
