package com.winter.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	static public Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/winter_boot", "root", "root");

		} catch (Exception e) {

			System.out.println("inside catch of getConnection()");

			e.printStackTrace();
		}

		return conn;
	}

}
