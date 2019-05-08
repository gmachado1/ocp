package br.com.conccurency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepAtomicManager {
	private AtomicInteger sheepAtomicCount = new AtomicInteger(0);

	private void atomicIncrementAndReport() {
		System.out.print(sheepAtomicCount.incrementAndGet() + " ");
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);
			SheepAtomicManager manager = new SheepAtomicManager();
			System.out.println("Atomic");
			for (int i = 0; i < 10; i++) 
				service.submit(() ->manager.atomicIncrementAndReport());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}