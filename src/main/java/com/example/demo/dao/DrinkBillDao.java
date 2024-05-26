package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.model.DrinkBill;

import com.example.demo.context.DBContext;

public class DrinkBillDao{
	static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs; 
	
	public static ArrayList<DrinkBill> showAllBill(){
		try {
            String query = "SELECT \r\n"
            		+ "    DrinkBill.billId, \r\n"
            		+ "    DrinkBill.productId, \r\n"
            		+ "    Product.name, \r\n"
            		+ "    DrinkBill.quantity, \r\n"
            		+ "	DrinkBill.date, \r\n"
            		+ "    DrinkBill.address, \r\n"
            		+ "    DrinkBill.phone, \r\n"
            		+ "    DrinkBill.price\r\n"
            		+ "FROM \r\n"
            		+ "    DrinkBill\r\n"
            		+ "INNER JOIN \r\n"
            		+ "    Product ON DrinkBill.productId = Product.id;";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
//            System.out.println("1");
            ArrayList<DrinkBill> list = new ArrayList<>();
            while (rs.next()) {
            	DrinkBill a = new DrinkBill(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
//            	System.out.println(a.toString());
                list.add(a);
            }
//            System.out.println("2");
            return list;
        } catch (Exception e) {
        	System.out.println("error");
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<DrinkBill> getBillById(int id){
		try {
            String query = "SELECT * FROM DrinkBill WHERE billId = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setInt(1, id);
            rs = ps.executeQuery(); 
            ArrayList<DrinkBill> list = new ArrayList<>();
            while (rs.next()) {
            	DrinkBill a = new DrinkBill(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static void insertDrinkBill(String productId, int quantity, String address, String date, String phone, Double price){
        String query = "INSERT INTO DrinkBill (productId, quantity, address, date,  phone, price)  VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1,productId);
            ps.setInt(2,quantity);
            ps.setString(3, address);
            ps.setString(4, date);
            ps.setString(5, phone);
            ps.setDouble(6, price);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }   
	
	public static void deleteProduct(int id){
        String query = "DELETE  FROM DrinkBill  WHERE billId=?";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void main(String[] args) {
//		System.out.println(showAllBill());
//		System.out.println(getBillById(1));
//		insertDrinkBill("CF002", 2, "Huỳnh Văn Nghệ", "0386751108", 50000.0);
//		deleteProduct(7);
	}
	
	
}