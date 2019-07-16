package com.rev.BACalculator.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.BACalculator.dao.DrinkDAO;
import com.rev.BACalculator.model.Preset;

@Service
public class DrinkServiceImp implements DrinkService{
	
	@Autowired
	private DrinkDAO drinkDAO;

	@Transactional
	public List<Preset> getDrink() {
		List<Preset> bList = drinkDAO.getDrinks();
		return bList;
	}
}
