package com.rev.BACalculator.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rev.BACalculator.dao.TransactionDAO;
import com.rev.BACalculator.model.Transaction;

@Service
public class TransactionServiceImp implements TransactionService{

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Override
	public void setTransaction(Transaction t) {
		transactionDAO.setTransaction(t);
	}

	@Transactional
	public List<Transaction> getAllTransactions() {
		List<Transaction> tList = transactionDAO.getAllTransactions();
		return tList;
	}

	@Override
	public List<Transaction> getUserTransactions(int userIdInt) {
		
		List<Transaction> tList = transactionDAO.getUserTransactions(userIdInt);
		return tList;
	}

	
}
