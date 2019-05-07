package br.com.functionalProgramming.exam;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exame {

	public static void main(String args[]) {
		{
			Stream<String> stream = Stream.iterate("", (s) -> s + "1");
			System.out.println(stream.limit(2).map(x -> x + "2"));
		}
		{
			Predicate<? super String> predicate = s -> s.startsWith("g");
			Stream<String> stream1 = Stream.generate(() -> "growl! ");
			Stream<String> stream2 = Stream.generate(() -> "growl! ");
			boolean b1 = stream1.anyMatch(predicate);
			boolean b2 = stream2.limit(3).allMatch(predicate);// sem o limit(3) fica rodando infinito
			System.out.println(b1 + " " + b2);
		}
		{
			LongStream ls = LongStream.of(1, 2, 3);
			OptionalLong opt = ls.map(n -> n * 10).filter(n -> n <= 10).findFirst();
			if (opt.isPresent()) {
				System.out.println(opt.getAsLong());
			}
			opt.ifPresent(System.out::print);
			System.out.println();

		}
		{
			System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining()));
		}
		{
			List<Integer> l1 = Arrays.asList(1, 2, 3);
			List<Integer> l2 = Arrays.asList(4, 5, 6);
			List<Integer> l3 = Arrays.asList();
			// Stream.of(l1, l2, l3).map(x-> x + 1).flatMap(x -> x.stream());
			// System.out.println(c);
		}
		{
			Stream<Integer> s = Stream.of(1);
			IntStream is = s.mapToInt(x -> x);
			DoubleStream ds = is.mapToDouble(x -> x);
			Stream s2 = ds.mapToObj(x -> x);
			s2.forEach(System.out::print);
		}
		{
			DoubleStream s = DoubleStream.of(1.2, 2.4);
			long d = s.peek(System.out::println).filter(x -> x > 2).count();
			System.out.println(d);
		}

	}

}
