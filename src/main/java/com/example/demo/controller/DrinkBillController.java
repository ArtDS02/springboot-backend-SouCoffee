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

import com.example.demo.dao.OrderDetailDao;
import com.example.demo.model.OrderDetail;

import com.example.demo.dao.DrinkBillDao;
import com.example.demo.model.DrinkBill;


@RestController
@RequestMapping("/DrinkBill")
public class DrinkBillController {

	@GetMapping("/hello")
	public String HelloWorld() {
		return "Hello world";
	}
	
	@GetMapping
	public ArrayList<DrinkBill> getDrinkBill(){
		return DrinkBillDao.showAllBill();
	}
	
	@PostMapping
    public String addNewDrinkBill(@RequestBody DrinkBill newDrinkBill) {
        try {
            System.out.println("Bat dau:");
            System.out.println(newDrinkBill);
            DrinkBillDao.insertDrinkBill(newDrinkBill.getProductId(), newDrinkBill.getQuantity(), newDrinkBill.getAddress(), newDrinkBill.getDate(), newDrinkBill.getPhone(), newDrinkBill.getPrice());
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed";
        }
    }
	
	@DeleteMapping("/{id}")
	public void deleteDrinkBill(@PathVariable("id") int id) {
		DrinkBillDao.deleteProduct(id);
		System.out.println("Bat delete:"+id);
	}
	
	@PutMapping("/{id}")
	public String updateDrinkBill(@PathVariable("id") int id, @RequestBody DrinkBill updatedProduct) {
		try {
//			DrinkBillDao.updateProduct(id, updatedProduct.getName(), updatedProduct.getPrice(), updatedProduct.getDescription(), updatedProduct.getImage());
			return "Success";
		} catch (Exception e) {
			return "Error";
		}
	}
}
