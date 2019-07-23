package com.rev.BACalculator.dao;

import java.util.List;

import com.rev.BACalculator.model.Transaction;

public interface ITransactionDAO {

	void setTransaction(Transaction t);
	List<Transaction> getAllTransactions();
}
