package br.com.conccurency.threadProblems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManager {
	private int sheepCount = 0;
	private AtomicInteger sheepAtomicCount = new AtomicInteger(0);

	private synchronized void incrementAndReport() {
		// synchronized (this) {
		System.out.print((++sheepCount) + " ");
		// }
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepManager manager = new SheepManager();
			for (int i = 0; i < 10; i++)
				synchronized (manager) {
					service.submit(() -> manager.incrementAndReport());
				}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}