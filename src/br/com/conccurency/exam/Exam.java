package br.com.conccurency.exam;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class Exam {
	public static void main(String[] args) {

		{// TODO Entender melhor isso
			ExecutorService service = Executors.newSingleThreadScheduledExecutor();
			service.scheduleWithFixedDelay(new Runnable() {
				@Override
				public void run() {
					System.out.println("scheduleWithFixedDelay: " + new Date());
				}
			}, 0, 1L, TimeUnit.MINUTES);
			Future<?> result = service.submit(() -> System.out.println("Wake Staff")); // w3
			System.out.println(result.get()); // w4
		}
		{
			AtomicLong value1 = new AtomicLong(0);
			final long[] value2 = { 0 };
			IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet());
			IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> ++value2[0]);
			System.out.println(value1 + " " + value2[0]);
		}
		{
			List<Integer> l1 = Arrays.asList(1, 2, 3);
			List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
			Set<Integer> s3 = new ConcurrentSkipListSet<>();
			s3.addAll(l1);

			for (Integer item : l2)
				l2.add(4); // x1
			for (Integer item : s3)
				s3.add(5); // x2
			System.out.println(l1.size() + " " + l2.size() + " " + s3.size());
		}
		{

		}
	}

	public void addAndPrintItems() {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(10);
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85, 7, TimeUnit.HOURS);
		System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
		System.out.print(" " + deque.pollLast(1, TimeUnit.MINUTES));
	}

}
