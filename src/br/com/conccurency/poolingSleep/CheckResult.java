package br.com.conccurency.poolingSleep;

public class CheckResult {
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for (int i = 0; i < 500; i++)
				CheckResult.counter++;
		}).start();
		while (CheckResult.counter < 100) {
			System.out.println("Not reached yet");
			Thread.sleep(1000); // 1 SECOND
		}
		System.out.println("Reached!");
	}
}