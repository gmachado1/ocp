package br.com.functionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MoreStreamExample {

	public static void main(String args[]) {
		{
			System.out.println("REDUCE");
			Stream<Integer> stream = Stream.of(1, 2, 3);
			System.out.println(stream.reduce(0, (s, n) -> s + n));
		}
		{
			System.out.println(" - OU - ");
			Stream<Integer> stream = Stream.of(1, 2, 3);
			System.out.println(stream.mapToInt(x -> x).sum());
		}
		System.out.println("\n\n");
		{
			System.out.println("AVARAGE");
			IntStream intStream = IntStream.of(1, 2, 3);
			OptionalDouble avg = intStream.average();
			System.out.println(avg.getAsDouble());
			System.out.println("\n\n");
		}
		{
			System.out.println("\n\n");
			DoubleStream oneValue = DoubleStream.of(3.14);
			DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
			oneValue.forEach(System.out::println);
			System.out.println();
			varargs.forEach(System.out::println);
			System.out.println("\n\n");
		}
		{
			System.out.println("\n\n");
			DoubleStream oneValue = DoubleStream.of(3.14);
			DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
			oneValue.forEach(System.out::println);
			System.out.println();
			varargs.forEach(System.out::println);
			System.out.println("\n\n");
		}
		{
			List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
			List<String> filtered = new ArrayList<>();
			for (String name : list) {
				if (name.length() == 4)
					filtered.add(name);
			}
			Collections.sort(filtered);
			Iterator<String> iter = filtered.iterator();
			if (iter.hasNext())
				System.out.println(iter.next());
			if (iter.hasNext())
				System.out.println(iter.next());
		}
		// JAVA 8
		{
			System.out.println("JAVA8");
			List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
			list.stream().filter(n -> n.length() == 4).sorted().limit(2).forEach(System.out::println);
		}
		{
			Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
			infinite.limit(5).filter(x -> x % 2 == 1).forEach(System.out::print); // 135
			System.out.println("");
		}
		{
			Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
			infinite.limit(5).peek(System.out::print).filter(x -> x % 2 == 1).forEach(System.out::print);
			System.out.println("");
		}
		{
			Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
			infinite.filter(x -> x % 2 == 1).limit(5).forEach(System.out::print); // 13579
		}
		{
			Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
			infinite.filter(x -> x % 2 == 1).peek(System.out::print).limit(5).forEach(System.out::print);
		}
		{
			Stream<Integer> stream = Stream.of(1, 2, 3);
			System.out.println(stream.reduce(0, (s, n) -> s + n));
		}
		{
			Stream<Integer> stream = Stream.of(1, 2, 3);
			System.out.println(stream.mapToInt(x -> x).sum());
		}
		{
			IntStream intStream = IntStream.of(1, 2, 3);
			OptionalDouble avg = intStream.average();
			System.out.println(avg.getAsDouble());
		}
		{
			System.out.println(" 	DoubleStream - ");
			DoubleStream empty = DoubleStream.empty();
			DoubleStream oneValue = DoubleStream.of(3.14);
			DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
			System.out.print(">>");
			empty.forEach(System.out::println);
			oneValue.forEach(System.out::println);
			varargs.forEach(System.out::println);
		}
		{
			System.out.println("doubleRandom");
			DoubleStream random = DoubleStream.generate(Math::random);
			DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
			random.limit(3).forEach(System.out::println);
			System.out.println();
			fractions.limit(3).forEach(System.out::print);

		}
		{
			IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
			count.forEach(System.out::println);
		}
		{
			IntStream rang = IntStream.range(0, 6);
			rang.forEach(System.out::print);
		}
		{
			System.out.println();
			IntStream rangeClosed = IntStream.rangeClosed(1, 5);
			rangeClosed.forEach(System.out::print);
		}
		{
			System.out.println("<<");
			Stream<String> objStream = Stream.of("penguin", "fish");
			IntStream intStream = objStream.mapToInt(s -> s.length());
			intStream.forEach(System.out::println);
		}
		{
			System.out.println("OptionalDouble ");
			IntStream stream = IntStream.rangeClosed(1, 10);
			OptionalDouble optional = stream.average();
			optional.ifPresent(System.out::println);
			System.out.println(optional.getAsDouble());
			System.out.println(optional.orElseGet(() -> Double.NaN));
		}
		{// pg209
			System.out.println("LongStream");
			LongStream longs = LongStream.of(3, 5, 10);
			long sum = longs.sum();
			System.out.println(sum); // 15
			longs = LongStream.of(3, 5, 10);
			System.out.println(longs.max());
			longs = LongStream.of(3, 5, 10);
			System.out.println(longs.average());
			longs = LongStream.of(3, 5, 10);
			DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
			OptionalDouble min = doubles.min(); // runs infinitely
		}
		{
			System.out.println("LongSummaryStatistics");

			LongSummaryStatistics longs = LongStream.of(3, 5, 10).summaryStatistics();
			long sum = longs.getSum();
			System.out.println(sum); // 15
			System.out.println(longs.getMax());
			System.out.println(longs.getAverage());
			DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
			OptionalDouble min = doubles.min(); // runs infinitely
		}
	}

	// If the stream is empty, we want to throw an exception:
	private static int max(IntStream ints) {
		OptionalInt optional = ints.max();
		return optional.orElseThrow(RuntimeException::new);
	}

	private static int range(IntStream ints) {
		IntSummaryStatistics stats = ints.summaryStatistics();
		if (stats.getCount() == 0)
			throw new RuntimeException();
		return stats.getMax() - stats.getMin();
	}
}
