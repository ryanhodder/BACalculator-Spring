package com.rev.BACalculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="calculation")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionid_seq")
	@SequenceGenerator(name = "transactionid_gen", sequenceName = "transactionid_seq", allocationSize = 1)
	@Column(name="transactionid")
	private int transactionid;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="strength")
	private double strength;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="time")
	private int time;
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="bodyweight")
	private int bodyweight;
	
	public Transaction() {
		
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getBodyweight() {
		return bodyweight;
	}

	public void setBodyweight(int bodyweight) {
		this.bodyweight = bodyweight;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", amount=" + amount + ", strength=" + strength
				+ ", userid=" + userid + ", time=" + time + ", gender=" + gender + ", bodyweight=" + bodyweight + "]";
	}
	
	
	
	
}
