package br.com.conccurency.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhaleDataParalelCalculator {
	public int processRecord(int input) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
// Handle interrupted exception
		}
		return input + 1;
	}

	public void processAllData(List<Integer> data) {
		data.parallelStream().map(a -> processRecord(a)).count();
	}

	public static void main(String[] args) {
		WhaleDataParalelCalculator calculator = new WhaleDataParalelCalculator();
// Define the data
		List<Integer> data = new ArrayList<Integer>();
		for (int i = 0; i < 4000; i++)
			data.add(i);
// Process the data
		long start = System.currentTimeMillis();
		calculator.processAllData(data);
		double time = (System.currentTimeMillis() - start) / 1000.0;
// Report results
		System.out.println("\nTasks completed in: " + time + " seconds");
	}

	{
		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream().map(s -> s.toUpperCase())
				.forEach(System.out::println);
		// ou
		Arrays.asList("jackal", "kangaroo", "lemur").parallelStream().map(s -> {
			System.out.println(s);
			return s.toUpperCase();
		}).forEach(System.out::println);
	}
	{// Avoiding Stateful Operations
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().map(i -> {
			data.add(i);
			return i;
		}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
				.forEachOrdered(i -> System.out.print(i + " "));
		System.out.println();
		for (Integer e : data) {
			System.out.print(e + " ");
		}
	}
	{
		System.out.println("\nFind Any STREAM");
		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).stream().findAny().get());
		System.out.println("\nFind Any PARALLELSTREAM");
		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().findAny().get());
		System.out.println("skip limit");
		System.out.print(Arrays.asList(1, 2, 3, 4, 5, 6).stream().skip(5).limit(2).findFirst());
	}
	{
		System.out.println("\n----------------REDUCE");
		System.out
				.println(Arrays.asList('w', 'o', 'l', 'f').stream().reduce("", (c, s1) -> c + s1, (s2, s3) -> s2 + s3));
	}
	{
		System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream().reduce(0, (a, b) -> (a - b))); // NOT AN
																											// ASSOCIATIVE
																											// ACCUMULATOR
	}
	{
		System.out.println("\n Concat----------------");
		System.out.println(Arrays.asList("w", "o", "l", "f").parallelStream().reduce("X", String::concat));
	}
	{

		System.out.println("\n ConcurrentSkipListSet----------------");
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll); //
		System.out.println(set); // [f, l, o, w]
	}
	{
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set); // [f, w, l, o]
	}
	{
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map = ohMy
				.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
		System.out.println(map); // {5=lions,bears, 6=tigers}
		System.out.println(map.getClass()); // java.util.concurrent.ConcurrentHashMap
	}
	{

		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> map = ohMy.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
	}
}