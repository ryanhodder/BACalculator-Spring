package com.rev.BACalculator.service;

import java.util.List;

import com.rev.BACalculator.model.Transaction;

public interface TransactionService {

	void setTransaction(Transaction t);
	List<Transaction> getAllTransactions();
	List<Transaction> getUserTransactions(int userIdInt);
}
