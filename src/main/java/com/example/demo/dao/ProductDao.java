package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.model.Product;

import com.example.demo.context.DBContext;

public class ProductDao{
	static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs; 
	
	public static ArrayList<Product> showAllProduct(){
		try {
            String query = "select * from Product";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
            	Product a = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<Product> getProductByType(String id){
		try {
            String query = "SELECT * FROM Product WHERE id LIKE '"+ id +"%'\r\n"
            		+ "";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery(); 
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
            	Product a = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static ArrayList<Product> getProductById(String id){
		try {
            String query = "SELECT * FROM Product WHERE id = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query); 
            ps.setString(1, id);
            rs = ps.executeQuery(); 
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
            	Product a = new Product(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
	public static void insertProduct(String id, String name, Double price, String description, String image){
        String query = "INSERT INTO Product(id, name, price, description, image) VALUES(?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setDouble(3, price);
            ps.setString(4, description);
            ps.setString(5, image);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }   
	
	public static void updateProduct(String id, String name, Double price, String description, String image){
        String query = "UPDATE Product SET name = ?, price = ?, description = ?, image = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setString(1,name);
            ps.setDouble(2,price);
            ps.setString(3, description);
            ps.setString(4, image);
            ps.setString(5, id);
            ps.executeUpdate();
            System.out.println("Success");
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void deleteProduct(String id){
        String query = "DELETE  FROM Product  WHERE id=?";
        try {
            conn = new DBContext().getConnection(); 
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            System.out.println("Success");
            ps.executeUpdate();
        } catch (Exception e){
        	System.out.println("Error: "+e);
        }
    }
	
	public static void main(String[] args) {
//		System.out.println(showAllProduct());
//		System.out.println(getProductByType("DK"));
//		System.out.println(getProductById("DK001"));
//		insertProduct("FL007", "Test", 12.3, "Đây là mô tả", "Test");
//		deleteProduct("FL006");
		updateProduct("CF001", "Cafe Sữa", 25000.0, "Cafe Sữa thơm ngon, hương vị đặc trưng của cafe Việt Nam.", "https://www.highlandscoffee.com.vn/vnt_upload/product/06_2023/thumbs/270_crop_HLC_New_logo_5.1_Products__PHINDI_CHOCO.jpg");
	}
	
	
}