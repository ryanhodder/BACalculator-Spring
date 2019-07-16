package com.rev.BACalculator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rev.BACalculator.model.Preset;
import com.rev.BACalculator.service.DrinkService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("preset")
public class DrinkController {

	@Autowired
	private DrinkService drinkService;
	
	@PostMapping("/calculate.do")
	public @ResponseBody String getDrinks()
	{
		System.out.println("DrinkController->calculate");
		
		List<Preset> drinkType1 = drinkService.getDrink();
		
		JsonObject jsonObject = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		
		for (Preset p : drinkType1) {
			jsonObject = new JsonObject();
			
			jsonObject.addProperty("presetid", p.getPresetid());
			jsonObject.addProperty("name", p.getName());
			jsonObject.addProperty("strength", p.getStrength());
			
			jsonArray.add(jsonObject);
		}

		return jsonArray.toString();
	}
}
