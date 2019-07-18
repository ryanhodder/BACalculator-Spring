package com.rev.BACalculator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/setTransaction.do")
	public void setTransaction(Transaction t) {
		System.out.println("TransactionController->setTransaction");
		
		transactionService.setTransaction(t);
	}
}
