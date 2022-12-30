package com.winter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winter.service.UserService;
import com.winter.to.User;

@Controller
public class UserController {

	public UserController() {
		System.out.println("inside UserController contr...");
	}

	@Autowired
	UserService service;

	@GetMapping("/registrationPage")
	public String registrationPage() {

		return "registration_page";
	}

	@PostMapping("/register")
	public String register(String username, String password, String name, String email) {

		System.out.println("inside register() " + username + ", " + password + ", " + name + ", " + email);

		service.saveUser(username, password, name, email);

		return "index";
	}

	//	@PostMapping("/login")
	//	public String login(String uname, String pwd) {
	//		
	//		System.out.println("inside login() "+uname+", "+pwd);
	//		
	//		String loginStatus = service.validate(uname, pwd);
	//		
	//		if(loginStatus.equals("Success")) {
	//			return "welcome";
	//		}
	//		else {
	//			return "index";
	//		}
	//		
	//		
	//	}

	//	@PostMapping("/login")
	//	public ModelAndView login(String uname, String pwd) {
	//		
	//		System.out.println("inside login() "+uname+", "+pwd);
	//		
	//		String loginStatus = service.validate(uname, pwd);
	//		
	//		if(loginStatus.equals("Success")) {
	//			ModelAndView modelAndView = new ModelAndView("welcome");
	//			modelAndView.addObject("username", uname);
	//			return modelAndView;
	//		}
	//		else {
	//			ModelAndView modelAndView = new ModelAndView("index");
	//			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again");
	//			return modelAndView;
	//		}
	//		
	//		
	//		
	//	}

	@PostMapping("/login")
	public ModelAndView login(String uname, String pwd) {

		System.out.println("inside login() " + uname + ", " + pwd);

		User user = service.validate(uname, pwd);

		if (user != null) {
			ModelAndView modelAndView = new ModelAndView("welcome");
			modelAndView.addObject("userData", user);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("index");
			modelAndView.addObject("errorMessage", "Wrong Credentials, please try again");
			return modelAndView;
		}
	}

	@GetMapping("/delete/{uname}")
	public ModelAndView delete(@PathVariable String uname) {

		System.out.println("the username is "+uname);

		service.deleteUser(uname);

		List<User> users = service.getUsers();

		ModelAndView modelAndView = new ModelAndView("user_master");

		modelAndView.addObject("allUsers", users);

		return modelAndView;


	}

}
