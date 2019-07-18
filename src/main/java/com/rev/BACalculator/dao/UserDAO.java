package com.rev.BACalculator.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
		em.persist(user); //persist = save
		return user;
	}
	
	@Override
	public String findPassword(String email) {
		
		Query nativeQuery = em.createNativeQuery("SELECT a.password FROM users a WHERE a.email='" + email + "'");
		
		String password = (String) nativeQuery.getSingleResult();		
		
		return password;
	}

	public int update(User luser) {
		return em.createNamedQuery("update")
				.setParameter("firstname", luser.getFirstname())
				.setParameter("lastname", luser.getLastname())
				.setParameter("username", luser.getUsername())
				.setParameter("password", luser.getPassword())
				.setParameter("email", luser.getEmail())
				.setParameter("bodyweight", luser.getBodyweight())
				.setParameter("gender", luser.getGender())
				.setParameter("userid", luser.getUserid()).executeUpdate();
		
	}
}
