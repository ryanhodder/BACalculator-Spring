package com.rev.BACalculator.service;

import com.rev.BACalculator.model.User;

public interface UserService {

	User login(String username, String password);
	User register(User user);
	int update(User luser);
	
}
