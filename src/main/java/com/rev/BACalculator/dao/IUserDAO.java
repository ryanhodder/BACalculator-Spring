package com.rev.BACalculator.dao;


import com.rev.BACalculator.model.User;


public interface IUserDAO 
{
	User register(User user);

	String findPassword(String email);

	User login(String username, String password);

	
}
