package com.rev.BACalculator.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
		System.out.println("username : " + username);
		
		System.out.println("password : " + password);
		
		try 
		{
			User returnable = em.createNamedQuery("login", User.class)
					.setParameter("username", username)
					.setParameter("password", password).getSingleResult();
					return returnable;	
		}catch(NoResultException nre) 
		{
			System.out.println("no results, login failed");
			return null;	
		}
	}

	@Override
	public User register(User user) {
		em.persist(user);
		return user;
	}

}
