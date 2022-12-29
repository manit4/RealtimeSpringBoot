package com.winter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.repository.UserRepository;
import com.winter.to.User;

@Service
public class UserService {
	
	public UserService() {
		System.out.println("inside UserService constr...");
	}
	
	@Autowired
	UserRepository repository;
	
	public void saveUser(String username, String password, String name, String email) {
		
		repository.addUser(username, password, name, email);
	}
	
//	public String validate(String username, String password) {
//		
//		String status = repository.validate(username, password);
//		
//		return status;
//	}
	
	public User validate(String username, String password) {
		
		User user = repository.validate(username, password);
		
		return user;
	}

}
