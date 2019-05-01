package br.com.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
		{
			System.out.println("\n\ninfinite\n\n");
			Stream<String> s = Stream.of("bonobo", "gorilla", "monkey");
			Stream<String> infinite = Stream.generate(() -> "chimp");
			s.findAny().ifPresent(System.out::println); // monkey
			infinite.findAny().ifPresent(System.out::println); // chimp
		}
		{
			System.out.println("\nInfinite + predicate\n\n");
			List<String> list = Arrays.asList("monkey", "2", "chimp");
			Stream<String> infinite = Stream.generate(() -> "chimp");
			Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
			System.out.println(list.stream().anyMatch(pred)); // true
			System.out.println(list.stream().allMatch(pred)); // false
			System.out.println(list.stream().noneMatch(pred)); // false
			System.out.println(infinite.anyMatch(pred)); // true
		}
		{
			Stream<String> s = Stream.of("Monkey - ", "Gorilla -  ", "Bonobo");
			s.forEach(System.out::print); // Monkey - Gorilla - Bonobo
		}

		{
			System.out.println("REDUCE");
			/**
			 * T reduce(T identity, BinaryOperator<T> accumulator) Optional<T>
			 * reduce(BinaryOperator<T> accumulator) <U> U reduce(U identity, BiFunction<U,?
			 * super T,U> accumulator, BinaryOperator<U> combiner)
			 */
			String[] array = new String[] { "w", "o", "l", "f" };
			String result = "";
			for (String s : array)
				result = result + s;
			System.out.println(result);

			Stream<String> stream = Stream.of("w", "o", "l", "f");
			String word = stream.reduce("", (s, c) -> s + c);
			System.out.println(word); // wolf

			Stream<String> stream1 = Stream.of("w", "o", "l", "f");
			String word1 = stream1.reduce("", String::concat);
			System.out.println(word1); // wolf

			Stream<Integer> stream2 = Stream.of(3, 5, 6);
			System.out.println(stream2.reduce(1, (a, b) -> a * b));
		}
		{
			System.out.println("  - - REDUCE - - ");
			BinaryOperator<Integer> op = (a, b) -> a * b;
			Stream<Integer> empty = Stream.empty();
			Stream<Integer> oneElement = Stream.of(3);
			Stream<Integer> threeElements = Stream.of(3, 5, 6);
			empty.reduce(op).ifPresent(System.out::print); // no output
			oneElement.reduce(op).ifPresent(System.out::print); // 3
			threeElements.reduce(op).ifPresent(System.out::print); // 90
		}
		{
			System.out.println("  - - reduce2 - - ");
			BinaryOperator<Integer> op = (a, b) -> a * b;
			Stream<Integer> empty = Stream.empty();
			Stream<Integer> oneElement = Stream.of(3);
			Stream<Integer> threeElements = Stream.of(3, 5, 6);
			empty.reduce(op).ifPresent(System.out::print); // no output
			oneElement.reduce(op).ifPresent(System.out::print); // 3
			threeElements.reduce(op).ifPresent(System.out::print); // 90
		}
		{
			System.out.println("\nCollect - stringBuider");
			Stream<String> stream = Stream.of("w", "o", "l", "f");
			StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
			System.out.println(word);
		}
		{
			System.out.println("Collect 2 - SET");
			Stream<String> stream = Stream.of("w", "o", "l", "f");
			Set<String> set = stream.collect(Collectors.toSet());
			System.out.println(set); // [f, w, l, o]
		}
		{
			System.out.println("Collect 3 - treeset");
			Stream<String> stream = Stream.of("w", "o", "l", "f");
			TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
			System.out.println(set); // [f, l, o, w]
		}

		{
			System.out.println("Filter");
			Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
			s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
		}
		{
			System.out.println("DISTINCT");
			Stream<String> s = Stream.of("duck ", "duck ", "duck ", "goose ");
			s.distinct().forEach(System.out::print); // duckgoose
		}
		{
			System.out.println("\nlimit skip");
			Stream<Integer> s = Stream.iterate(1, n -> n + 1);
			s.skip(5).limit(2).forEach(System.out::println); // 67
		}
		{
			System.out.println("\nlimit skip");
			Stream<Integer> s = Stream.iterate(1, n -> n + 1);
			s.skip(5).limit(2).forEach(System.out::println); // 67
		}
		{
			System.out.println("  MAP ");
			Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
			s.map(String::length).forEach(System.out::print); // 676
		}
		{
			System.out.println("\n FLAPMAP ");
			List<String> zero = Arrays.asList();
			List<String> one = Arrays.asList("Bonobo");
			List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
			Stream<List<String>> animals = Stream.of(zero, one, two);
			animals.flatMap(l -> l.stream()).forEach(System.out::println);
		}
		{
			System.out.println("\n  SORTED   ");

			Stream<String> s = Stream.of("brown-", "bear-");
			s.sorted().forEach(System.out::println); // bear-brown-

			Stream<String> s1 = Stream.of("brown bear-", "grizzly-");
			s1.sorted(Comparator.reverseOrder()).forEach(System.out::print); // grizzly-brown bear-
		}
		{
			System.out.println("peek");
			Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
			long count = stream.filter(s -> s.startsWith("g")).peek(System.out::println).count(); // grizzly
			System.out.println(count); // 1
		}
		{
			System.out.println("\n  MAP ");
			List<Integer> numbers = new ArrayList<>();
			List<Character> letters = new ArrayList<>();
			numbers.add(1);
			letters.add('a');
			Stream<List<?>> stream = Stream.of(numbers, letters);
			stream.map(List::size).forEach(System.out::println); // 11
			
			System.out.println("\n  PEEK ");
			StringBuilder builder = new StringBuilder();
			Stream<List<?>> good = Stream.of(numbers, letters);
			good.peek(l -> builder.append(l)).map(List::size).forEach(System.out::println); // 11
			System.out.println(builder); // [1][a]
		}

	}

}
