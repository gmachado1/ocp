package br.com.conccurency;

public class AccountDanger implements Runnable {

	private Account acct = new Account();

	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		Thread two = new Thread(r);

		one.setName(" - Hamilton: ");
		two.setName(" - Ana: ");

		one.start();
		two.start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithDraw(10);
			if (acct.getBalance() < 0) {
				System.out.println("account is over Draw!");
			}
		}
	}

	private void makeWithDraw(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.getMessage();
				e.printStackTrace();
			}

			acct.withDraw(amt);
			System.out.println(Thread.currentThread().getName() + "completes the withdraw");
		} else {
			System.out.println("Not enought in account for" + Thread.currentThread().getName() + " to withdraw "
					+ acct.getBalance());
		}

	}

}
