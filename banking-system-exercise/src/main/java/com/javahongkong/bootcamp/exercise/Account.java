package com.javahongkong.bootcamp.exercise;

import java.math.BigDecimal;

public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private Long accountNumber;
	private int pin;
	private double balance;

	protected Account(AccountHolder accountHolder, Long accountNumber, int pin, double startingDeposit) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}
	@Override
	public AccountHolder getAccountHolder() {
		// complete the function
		return this.accountHolder;
	}
	@Override
	public boolean validatePin(int attemptedPin) {
		// complete the function
		if (this.pin== attemptedPin)
			return true;
		return false;
	}
	@Override
	public double getBalance() {
		// complete the function
		return this.balance;
	}
	@Override
	public double getPin() {
		// complete the function
		return this.pin;
	}
	@Override
	public Long getAccountNumber() {
		// complete the function
		return this.accountNumber;
	}
	@Override
	public void creditAccount(double amount) {
		// complete the function
		// BigDecimal
		// this.balance = BigDecimal.valueOf(this.balance).add(BigDecimal.valueOf(amount)).doubleValue();
		this.balance += amount;
	}
	@Override
	public boolean debitAccount(double amount) {
		// complete the function
		if (amount > this.balance){
			System.err.println("Debit was unsuccessful.");
			return false;
		}
		//this.balance = BigDecimal.valueOf(this.balance).subtract(BigDecimal.valueOf(amount)).doubleValue();
		this.balance -= amount;
		System.err.println("This transaction should have overdrawn the account.");
		return true;
	}
}
