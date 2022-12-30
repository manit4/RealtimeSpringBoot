package com.winter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.winter.service.UserService;
import com.winter.to.User;

@Controller
public class MasterController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/masterPage")
	public String masterPage() {
		
		return "master_page";
	}
	
	@GetMapping("/userMasterPage")
	public ModelAndView getUserMasterPage() {
		
		List<User> users = service.getUsers();
		
		ModelAndView modelAndView = new ModelAndView("user_master");
		
		modelAndView.addObject("allUsers", users);
		
		return modelAndView;
	}

}
