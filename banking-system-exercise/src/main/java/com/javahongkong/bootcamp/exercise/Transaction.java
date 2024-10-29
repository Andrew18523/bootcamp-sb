package com.javahongkong.bootcamp.exercise;

public class Transaction implements TransactionInterface {
	private Long accountNumber;
	private Bank bank;

	/**
	 *
	 * @param bank
	 *                      The bank where the account is housed.
	 * @param accountNumber
	 *                      The customer's account number.
	 * @param attemptedPin
	 *                      The PIN entered by the customer.
	 * @throws Exception
	 *                   Account validation failed.
	 */
	public Transaction(Bank bank, Long accountNumber, int attemptedPin) throws Exception {
		// complete the function
		this.bank=bank;
		this.accountNumber = accountNumber;
		if ( this.bank.authenticateUser(accountNumber, attemptedPin)==false){
			throw new Exception();
		}

	}
	@Override
	public double getBalance() {
		return this.bank.getBalance(this.accountNumber);
	}
	@Override
	public void credit(double amount) {
		// complete the function
		this.bank.credit(this.accountNumber, amount);
	}
	@Override
	public boolean debit(double amount) {
		// complete the function
		return this.bank.debit(this.accountNumber, amount);
	}
}
