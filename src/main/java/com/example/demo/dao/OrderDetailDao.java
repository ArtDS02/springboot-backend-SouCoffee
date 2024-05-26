package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.model.OrderDetail;

import com.example.demo.context.DBContext;

public class OrderDetailDao {
	static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs; 
	
	public static ArrayList<OrderDetail> showAllOrderDetail(){
		try {
            String query = "select * from OrderDetail";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<OrderDetail> list = new ArrayList<>();
            while (rs.next()) {
            	OrderDetail a = new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<OrderDetail> getOrderDetailByType(String id){
		try {
            String query = "SELECT * FROM OrderDetail WHERE orderDetailId LIKE '"+ id +"%'\r\n"
            		+ "";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<OrderDetail> list = new ArrayList<>();
            while (rs.next()) {
            	OrderDetail a = new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<OrderDetail> getOrderDetailById(String id){
		try {
            String query = "SELECT * FROM OrderDetail WHERE orderDetailId = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, id);
            rs = ps.executeQuery(); 
            ArrayList<OrderDetail> list = new ArrayList<>();
            while (rs.next()) {
            	OrderDetail a = new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static void insertOrderDetail(int orderId, String BoxId, String DrinkId, String DecorId, String Note, String Phone, Double price){
        String query = "INSERT INTO OrderDetail(orderId, BoxId, DrinkId, DecorId, Note, Phone, price) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1,orderId);
            ps.setString(2,BoxId);
            ps.setString(3,DrinkId);
            ps.setString(4,DecorId);
            ps.setString(5,Note);
            ps.setString(6, Phone);
            ps.setDouble(7, price);
            ps.executeUpdate();
            System.out.println("Success: "+DecorId);
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }   
	
	public static void updateOrderDetail(int orderDetailId,  String BoxId, String DrinkId, String DecorId, String Note, String Phone, Double price){
        String query = "UPDATE OrderDetail SET BoxId = ?, DrinkId = ?, DecorId = ?, Note = ?, Phone = ?, price = ? WHERE orderDetailId = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1,BoxId);
            ps.setString(2, DrinkId);
            ps.setString(3, DecorId);
            ps.setString(4, Note);
            ps.setString(5, Phone);
            ps.setDouble(6,price);
            ps.setInt(7, orderDetailId);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void deleteOrderDetail(int orderDetailId){
        String query = "DELETE FROM OrderDetail  WHERE orderDetailId= ?";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1,orderDetailId);
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void main(String[] args) {
//			System.out.println(showAllOrderDetail());
//			System.out.println(getOrderDetailByType("OD"));
//			System.out.println(getOrderDetailById("OD001"));
//			insertOrderDetail(3, "BX001", "CF001", "FL001", "Đẹp tuyệt vời", "0386751108", 123.0);
//			updateOrderDetail("OD005", "BX001", "CF001", "FL001", "Đẹp tuyệt vời 22", "0386751108", 123.0);
//			deleteOrderDetail(27);
	}
}
