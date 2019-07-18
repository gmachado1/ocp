package br.com.conccurency;

public class Account {

	private int balance = 50;

	public int getBalance() {
		return balance;
	}
	public void withDraw(int amount) {
		balance = balance - amount;
	}
}
