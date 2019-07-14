package com.rev.BACalculator.controllers;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.BACalculator.model.User;
import com.rev.BACalculator.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login.do")
	public @ResponseBody void login(@RequestParam("username") String username, 
									@RequestParam("password") String password) 
	{
		System.out.println("UserController->login");
		
		User loginUser = userService.login(username, password);
		
		//TODO: STORE SESSION VARS
		
		
		
	}
	
	@PostMapping("/register.do")
	public @ResponseBody void register(@RequestParam("username") String userName, @RequestParam("password") String password,
									   @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
									   @RequestParam("email") String email, @RequestParam("gender") String gender,
									   @RequestParam("bodyweight") double bodyWeight)
	{
		User luser = new User();
		luser.setUsername(userName);
		luser.setPassword(password);
		luser.setFirstname(firstName);
		luser.setLastname(lastName);
		luser.setEmail(email);
		luser.setGender(gender);
		luser.setBodyweight(bodyWeight);
		
		User regUser = userService.register(luser);
		
	} 
	
}