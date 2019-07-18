package com.rev.BACalculator.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rev.BACalculator.model.Transaction;

@Repository
public class TransactionDAO implements ITransactionDAO{

	@Autowired
	private EntityManager em;
	
	@Override
	public void setTransaction(Transaction t) {
		em.persist(t);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		try {
			List<Transaction> returnable = em.createNamedQuery("getAllTransactions", Transaction.class).getResultList();
			return returnable;
		}
		catch(Exception e) {
			System.out.println("Error getting transaction list: " + e.getMessage());
			return null;
		}
	}

}
