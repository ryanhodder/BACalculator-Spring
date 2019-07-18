package com.rev.BACalculator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rev.BACalculator.model.Preset;

@Repository
public class DrinkDAO implements IDrinkDAO{
	
	@Autowired
	private EntityManager em;

	@Override
	public List<Preset> getDrinks() {
		try {
			List<Preset> returnable = em.createNamedQuery("getDrinks", Preset.class).getResultList(); //createQuery?
			return returnable;
		}
		catch(Exception e){
			System.out.println("getDrinks Exception: " + e.getMessage());
			return null;
		}
	}
}
