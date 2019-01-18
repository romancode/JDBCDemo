package com.krosstek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Employee> employees= new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrm?autoReconnect=true&useSSL=false", "root", "12345678");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

			while(resultSet.next()) {
				
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setAge(resultSet.getInt("age"));
				
				employees.add(employee);
			}
			
			for (Employee employee : employees) {
				System.out.println(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
