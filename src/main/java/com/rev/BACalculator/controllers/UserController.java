package com.rev.BACalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.rev.BACalculator.model.User;
import com.rev.BACalculator.service.UserService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login.do")
	public @ResponseBody String login(@RequestParam("username") String username, 
									@RequestParam("password") String password) 
	{
		System.out.println("UserController->login");
		
		User loginUser = userService.login(username, password);
		
		JsonObject j = new JsonObject();
		
		j.addProperty("userid", loginUser.getUserid());
		j.addProperty("firstname", loginUser.getFirstname());
		j.addProperty("lastname", loginUser.getLastname());
		j.addProperty("username", loginUser.getUsername());
		j.addProperty("password", loginUser.getPassword());
		j.addProperty("email", loginUser.getEmail());
		j.addProperty("gender", loginUser.getGender());
		j.addProperty("bodyweight", loginUser.getBodyweight());

		return j.toString();
		
	}
	
	@PostMapping("/register.do")
	public @ResponseBody String register(@RequestParam("username") String userName, @RequestParam("password") String password,
									   @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
									   @RequestParam("email") String email, @RequestParam("gender") String gender,
									   @RequestParam("bodyweight") String bodyWeight)
	{
		User luser = new User();
		
		System.out.println(userName);
		
		System.out.println(password);
		
		System.out.println(lastName);
		
		System.out.println(firstName);
		
		System.out.println(email);
		
		System.out.println(gender);
		
		System.out.println(bodyWeight);
		
		luser.setUsername(userName);
		luser.setPassword(password);
		luser.setFirstname(firstName);
		luser.setLastname(lastName);
		luser.setEmail(email);
		luser.setGender(gender);
		luser.setBodyweight(Double.parseDouble(bodyWeight));
		
		User regUser = userService.register(luser);
		
		return "shit";
	} 
	
}
