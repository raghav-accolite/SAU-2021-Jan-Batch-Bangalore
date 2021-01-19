package com.JavaAssignment.mainPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Assignment {
	public static void main(String[] args) throws IOException,ClassNotFoundException, SQLException {
		FileInputStream in;
		FileOutputStream out;
		
		in = new FileInputStream("C:\\Users\\RGV\\eclipse-workspace\\JavaAssignement-2-evening\\src\\com\\JavaAssignment\\mainPackage\\test.txt");
		out = new FileOutputStream("C:\\Users\\RGV\\eclipse-workspace\\JavaAssignement-2-evening\\src\\com\\JavaAssignment\\mainPackage\\test.txt");
		
		int c; // ASCII
		Random random= new Random();
		while (true) {
			c = random.nextInt(100)+1 ;
			out.write(c);
			if(c%5==0) {
				break;
			}
		}
		List<Integer> lis = new ArrayList<Integer>();
		while ((c = in.read()) != -1) {
			lis.add(c);
			
	}
		in.close();
		out.close();
		int multipleOf5= lis.stream().filter(e-> e%5==0).mapToInt(w->w).sum();
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		
		String sql = "insert into test values(?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		String ids = String.valueOf(multipleOf5);
		String name="Raghav Mandowara";
		preparedStatement.setString(1, ids);
		preparedStatement.setString(2, name);
		
		preparedStatement.executeUpdate();
		
		Statement statement = connection.createStatement();
		String sqlt = " select * from test";
		ResultSet result = statement.executeQuery(sqlt);

		while(result.next()) {
		    String id = result.getString("id");
		    String names = result.getString("name");
		    System.out.println("Name,id - " + names + "," + id); 
		}
		connection.close();
		
		

	}
}
