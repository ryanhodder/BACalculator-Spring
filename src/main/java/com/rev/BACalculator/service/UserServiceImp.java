package com.rev.BACalculator.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.BACalculator.dao.UserDAO;
import com.rev.BACalculator.model.User;
import com.rev.BACalculator.validator.UserValidator;


@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserValidator validator;
	
	@Transactional
	public User login(String username, String password) {
		
		User luser = userDAO.login(username, password);	
		
		return luser;
	}

	@Transactional
	public User register(User user) {
		
		validator.validateUser(user);
		
		User luser = userDAO.register(user);
		
		return luser;
	}

}
