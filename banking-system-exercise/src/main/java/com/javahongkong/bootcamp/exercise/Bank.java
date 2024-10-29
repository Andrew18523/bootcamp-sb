package com.javahongkong.bootcamp.exercise;

import java.util.LinkedHashMap;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts; // object reference
	private static long accountCount =0L;

	public Bank() {
		this.accounts = new LinkedHashMap<>();
	}

	public Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		accountCount +=1 ;
		accounts.put(accountCount,new CommercialAccount(company,accountCount,pin,startingDeposit));		
		return accountCount;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		accountCount +=1;
		accounts.put(accountCount, new ConsumerAccount(person, 1L, pin, startingDeposit));
		return accountCount;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		return this.accounts.get(accountNumber).validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		return this.accounts.get(accountNumber).getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		this.accounts.get(accountNumber).creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		// complete the function
		return this.accounts.get(accountNumber).debitAccount(amount);
	}
}
