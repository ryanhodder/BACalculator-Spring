package com.rev.BACalculator.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rev.BACalculator.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private EntityManager em;
	
	
	@Override
	public User login(String username, String password) 
	{
		User returnable = (User) em.createNamedQuery("login")
		.setParameter("username", username)
		.setParameter("password", password).getSingleResult();
		return returnable;
	}

	@Override
	public User register(User user) {
		em.persist(user);
		return user;
	}

}
