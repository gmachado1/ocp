package br.com.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamSource {

	public static void main(String args[]) {
		{
			Stream<String> empty = Stream.empty(); // count = 0
			Stream<Integer> singleElement = Stream.of(1); // count = 1
			Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 2

			System.out.println(empty);
			System.out.println(singleElement);
			System.out.println(fromArray);

			List<String> list = Arrays.asList("a", "b", "c");
			Stream<String> fromList = list.stream();
			Stream<String> fromListParallel = list.parallelStream();

		}

		{
			Stream<String> s = Stream.of("monkey", "ape", "bonobo");
			Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
			min.ifPresent(System.out::println); // ape
		}

		{
			Stream<Double> randoms = Stream.generate(Math::random);
			Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
			System.out.println();

			Stream<String> s = Stream.of("monkey", "gorilla", "bonobo", "xita");
			// System.out.println(s.count()); // SE DESCOMENTAR DA ERRO
			// java.lang.IllegalStateException: stream has already been operated upon or
			// closed
			Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
			min.ifPresent(System.out::println);
		}
		

	}

}
