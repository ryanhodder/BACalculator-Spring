package com.rev.BACalculator.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.BACalculator.dao.UserDAO;
import com.rev.BACalculator.model.User;

public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User login(String username, String password) {
		
		User luser = userDAO.login(username, password);
		
		
		return luser;
	}

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
