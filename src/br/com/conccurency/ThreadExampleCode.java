package br.com.conccurency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ThreadExampleCode {

	public static void main(String[] args) {
		{
			System.out.println("begin");
			(new ReadInventoryThread()).start();
			(new Thread(new PrintData())).start();
			(new ReadInventoryThread()).start();
			System.out.println("end");
		}
		{
			ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
			Runnable task1 = () -> System.out.println("Hello Zoo");
			Callable<String> task2 = () -> "Monkey";
			Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
			Future<?> result2 = service.schedule(task2, 8, TimeUnit.MINUTES);
		}
		{
			System.out.println("Listas  \n");
			Map<String, Integer> map = new ConcurrentHashMap<>();
			map.put("zebra", 52);
			map.put("elephant", 10);
			System.out.println(map.get("elephant"));
			Queue<Integer> queue = new ConcurrentLinkedQueue<>();
			queue.offer(31);
			System.out.println(queue.peek());
			System.out.println(queue.poll());
			Deque<Integer> deque = new ConcurrentLinkedDeque<>();
			deque.offer(10);
			deque.push(4);
			System.out.println(deque.peek());
			System.out.println(deque.pop());
		}
		{
			System.out.println("BlockingDeque");
			try {
				BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
				blockingDeque.offer(91);
				blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
				blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
				blockingDeque.offer(3, 4, TimeUnit.SECONDS);
				System.out.println(blockingDeque);
				System.out.println(blockingDeque.poll());
				System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
				System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
				System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				// Handle interruption
			}
		}
		{
			List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 3, 52)));
			synchronized (list) {
				for (int data : list)
					System.out.print(data + ">>");
			}
		}
		{
			Map<String, Object> foodData = new HashMap<String, Object>();
			foodData.put("penguin", 1);
			foodData.put("flamingo", 2);
			Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
			try {
				for (String key : synchronizedFoodData.keySet())
					synchronizedFoodData.remove(key);
			} catch (ConcurrentModificationException e) {
				System.out.println(
						"Unlike the concurrent collections, the synchronized collections also throw an exception\r\n"
								+ "if they are modifi ed within an iterator by a single thread.");
				e.printStackTrace();
			}
		}

		{
			Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
			Stream<Integer> parallelStream = stream.parallel();
			/**
			 * parallel() on an existing stream to convert it to one that supports
			 * multi-threaded processing, Be aware that parallel() is an intermediate
			 * operation that operates on the original stream.
			 **/
		}
		{
			Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();
		}
		{
			Arrays.asList(1, 2, 3, 4, 5, 6).stream().forEach(s -> System.out.print(s + " "));
			System.out.println("\nParalelo");
			Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEach(s -> System.out.print(s + " "));
			/**
			 * Streams API includes an alternate version of the forEach() operation called
			 * forEachOrdered(), which forces a parallel stream to process the results in
			 * order at the cost of performance
			 */
			Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().forEachOrdered(s -> System.out.print(s + " "));
		}

	}
}