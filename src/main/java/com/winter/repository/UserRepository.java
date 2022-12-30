package com.winter.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.winter.db.DBConnection;
import com.winter.to.User;

@Repository
public class UserRepository {

	public UserRepository() {
		System.out.println("inside UserRepository contr...");
	}

	public void addUser(String username, String password, String name, String email) {

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn.prepareStatement("insert into user values(?, ?, ?, ?)");

			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setString(4, email);

			statement.executeUpdate();
		} catch (Exception e) {

			System.out.println("inside catch of addUser()");
			e.printStackTrace();
		}
	}

//	public String validate(String username, String password) {
//		
//		String loginStatus = "Failed";
//
//		try {
//
//			Connection conn = DBConnection.getConnection();
//
//			PreparedStatement statement = conn.prepareStatement("select * from user where username = ? and password = ?");
//
//			statement.setString(1, username);
//			statement.setString(2, password);
//
//			ResultSet rs = statement.executeQuery();
//			
//			if(rs.next()) {
//				
//				loginStatus = "Success";
//			}
//			
//		} catch (Exception e) {
//
//			System.out.println("inside catch of addUser()");
//			e.printStackTrace();
//		}
//		return loginStatus;
//	}

	public User validate(String username, String password) {

		User user = null;

		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn
					.prepareStatement("select * from user where username = ? and password = ?");

			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				String uname = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);

				user = new User(username, password, name, email);
			}

		} catch (Exception e) {

			System.out.println("inside catch of addUser()");
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> getAllUsers() {
		
		List<User> users = new ArrayList<User>();
		User user = null;
		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn
					.prepareStatement("select * from user");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String uname = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				String email = rs.getString(4);

				user = new User(uname, pwd, name, email);
				users.add(user);
			}

		} catch (Exception e) {

			System.out.println("inside catch of addUser()");
			e.printStackTrace();
		}
		return users;
		
	}
	
	public void delete(String username) {
		
		try {

			Connection conn = DBConnection.getConnection();

			PreparedStatement statement = conn
					.prepareStatement("delete from user where username = ?");
			
			statement.setString(1, username);

			statement.executeUpdate();

		} catch (Exception e) {

			System.out.println("inside catch of addUser()");
			e.printStackTrace();
		}
	}
}
