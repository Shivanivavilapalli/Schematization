package crudoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createdatabase {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	
//jdbc connection contains 5 steps
//1:loading driver
//2:connection creation
//3:statement creation
//4:statement execution
//5:close
	public static void main(String[] args) {
		
		try {
			Scanner src = new Scanner(System.in);
		
			Class.forName(Driver);
			
	 conn=DriverManager.getConnection(url, username, password);
	 System.out.println("enter database name");
	 String sql = "create database "+ src.next();

		
			
		pmst = conn.prepareStatement(sql);
		 
		int i = pmst.executeUpdate();
		if (i>0) {
			System.out.println("successfully created");
		}
		else {
			System.out.println("error"); 
			
		}
			conn.close();
			pmst.close();
			src.close();
		} catch (Exception e) {
			e.printStackTrace();

			
		}
		
	}
}
