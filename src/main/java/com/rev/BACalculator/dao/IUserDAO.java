package com.rev.BACalculator.dao;


import com.rev.BACalculator.model.User;


public interface IUserDAO 
{
	User register(User user);

	User login(String username, String password);
	
	String findPassword(String email);
}
