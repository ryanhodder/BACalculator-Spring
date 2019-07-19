package com.rev.BACalculator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rev.BACalculator.model.Transaction;
import com.rev.BACalculator.service.TransactionService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/getAllTransactions.do")
	public @ResponseBody String getAllTransactions() {
		System.out.println("TransctionController->getAllTransactions");
		
		List<Transaction> tList = transactionService.getAllTransactions();
		
		JsonObject j = new JsonObject();
		JsonArray jArray = new JsonArray();
		
		for(Transaction t: tList) {
			j = new JsonObject();
			
			j.addProperty("transactionid", t.getTransactionid());
			j.addProperty("amount", t.getAmount());
			j.addProperty("strength", t.getStrength());
			j.addProperty("userid", t.getUserid());
			j.addProperty("time", t.getTime());
			j.addProperty("gender", t.getGender());
			j.addProperty("bodyweight", t.getBodyweight());
			
			jArray.add(j);
		}
		
		return jArray.toString();
	}
	
	@PostMapping("/getUserTransactions.do")
	public @ResponseBody String getAllUserTransactions(@RequestParam("userid") String userid) 
	{
		System.out.println("TransctionController->getAllUserTransactions");
		
		int userIdInt = Integer.parseInt(userid);
		
		System.out.println(userIdInt);
		
		List<Transaction> tList = transactionService.getUserTransactions(userIdInt);
		
		JsonObject j;
		JsonArray jArray = new JsonArray();
		
		for(Transaction t: tList) {
			j = new JsonObject();
			
			j.addProperty("transactionid", t.getTransactionid());
			j.addProperty("amount", t.getAmount());
			j.addProperty("strength", t.getStrength());
			j.addProperty("userid", t.getUserid());
			j.addProperty("time", t.getTime());
			j.addProperty("gender", t.getGender());
			j.addProperty("bodyweight", t.getBodyweight());
			
			jArray.add(j);
		}
		
		return jArray.toString();
		
	}
	
	@PostMapping("/setTransaction.do")
	public void setTransaction(@RequestParam("amount") double amount, @RequestParam("strength") double strength,
								@RequestParam("userid") int userid, @RequestParam("time") int time,
								@RequestParam("gender") String gender, @RequestParam("bodyweight") double bodyweight) 
	{
		System.out.println("TransactionController->setTransaction");
		
		Transaction t = new Transaction();
		
		t.setAmount(amount);
		t.setStrength(strength);
		t.setUserid(userid);
		t.setTime(time);
		t.setGender(gender);
		t.setBodyweight(bodyweight);
		
		transactionService.setTransaction(t);
	}
}