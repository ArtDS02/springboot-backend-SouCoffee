package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.model.Product;
import com.example.demo.model.Orders;

import com.example.demo.context.DBContext;

public class OrderDao {
	static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs; 
	
	public static ArrayList<Orders> showAllOrder(){
		try {
            String query = "select * from Orders";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<Orders> list = new ArrayList<>();
            while (rs.next()) {
            	Orders a = new Orders(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(2));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<Orders> getOrderByType(String id){
		try {
            String query = "SELECT * FROM Orders WHERE orderId LIKE '"+ id +"%'\r\n"
            		+ "";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<Orders> list = new ArrayList<>();
            while (rs.next()) {
            	Orders a = new Orders(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(2));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<Orders> getOrderById(String id){
		try {
            String query = "SELECT * FROM Orders WHERE orderId = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, id);
            rs = ps.executeQuery(); 
            ArrayList<Orders> list = new ArrayList<>();
            while (rs.next()) {
            	Orders a = new Orders(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(2));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static void insertOrder(String id, String date, String status, String address, Double price){
        String query = "INSERT INTO Orders(orderId, price, date, Status, Address) VALUES(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setDouble(2, price);
            ps.setString(3,date);
            ps.setString(4, status);
            ps.setString(5, address);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }   
	
	// Test thử vừa add order mới vừa lấy ra
	public static Orders insertAndGetOrder(String date, String status, String address, Double price) {
	    String query = "INSERT INTO Orders(price, date, Status, Address) " +
	                   "OUTPUT inserted.orderId, inserted.price, inserted.date, inserted.Status, inserted.Address " +
	                   "VALUES(?,?,?,?)";
	    try {
	        Connection conn = new DBContext().getConnection(); 
	        PreparedStatement ps = conn.prepareStatement(query);
//	        ps.setString(1, id);
	        ps.setDouble(1, price);
	        ps.setString(2, date);
	        ps.setString(3, status);
	        ps.setString(4, address);
	        ResultSet rs = ps.executeQuery();
	        System.out.println("Show:");
	        if (rs.next()) {
	            int insertedId = rs.getInt("orderId");
	            Double insertedPrice = rs.getDouble("price");
	            String insertedDate = rs.getString("date");
	            String insertedStatus = rs.getString("Status");
	            String insertedAddress = rs.getString("Address");
	            return new Orders(insertedId, insertedDate, insertedStatus, insertedAddress, insertedPrice);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public static void updateOrder(int id, String date, String status, String address, Double price){
        String query = "UPDATE Orders SET price = ?, date = ?, Status = ?, Address = ? WHERE orderId = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setDouble(1,price);
            ps.setString(2,date);
            ps.setString(3, status);
            ps.setString(4, address);
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void deleteOrder(int id){
        String query = "DELETE FROM OrderDetail WHERE orderId = ?;\r\n"
        				+ "DELETE FROM Orders WHERE orderId = ?;\r\n"
        					+ "";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2,id);
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void main(String[] args) {
//			System.out.println(showAllOrder());
//			System.out.println(getOrderByType("DK"));
//			System.out.println(getOrderById("OR001"));
//			System.out.println(insertAndGetOrder("2024-05-14", "complete", "123 Huỳnh Văn Nghệ, Đà Nẵng", 123.0));
//			insertOrder("OR004", "2024-05-14", "complete", "123 Huỳnh Văn Nghệ, Đà Nẵng", 123.0);
//			updateOrder(1, "2024-05-14", "complete", "123 Huỳnh Văn Nghệ, Đà Nẵnggggg", 123.0);
//			deleteOrder(36);
	}
}
