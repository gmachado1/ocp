package br.com.functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamPipeline {

	public static void main(String args[]) {

		{
			List<String> cats = new ArrayList<>();
			cats.add("Annie");
			cats.add("Ripley");
			Stream<String> stream = cats.stream();
			cats.add("KC");
			System.out.println(stream.count());

		}
		{
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			String result = ohMy.collect(Collectors.joining(", "));
			System.out.println(result); // lions, tigers, bears
		}
		{
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Double result = ohMy.collect(Collectors.averagingInt(String::length));
			System.out.println(result); // 5.333333333333333
		}
		{
			System.out.println("\n\n ####TREESET");
			Stream<String> stream = Stream.of("w", "o", "l", "f");
			TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
			System.out.println(set); // [f, l, o, w]
		}
		{
			// TODO vver pq não funciona
//			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//			 TreeSet<String> result = ohMy.filter(s ->
//			 s.startsWith("t").collect(Collectors.toSet(TreeSet::new));
//			 TreeSet<String> result = ohMy.filter(s->s.startsWith("t").collect(Collectors.toCollection(TreeSet::new)));
//			 System.out.println(result); // [tigers]
		}
		{
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<String, Integer> map = ohMy.collect(Collectors.toMap(s -> s, String::length));
			System.out.println(map); // {lions=5, bears=5, tigers=6}
		}
		{
			try {
				Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
				Map<Integer, String> map = ohMy.collect(Collectors.toMap(String::length, k -> k)); // BAD
			} catch (IllegalStateException e) {
				System.out.println(" erro tratado!");
			}
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<Integer, String> map = ohMy
					.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
			System.out.println(map); // {5=lions,bears, 6=tigers}
			System.out.println(map.getClass()); // class. java.util.HashMap
		}
		{// TREEMAP Collectors.toMap()
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			TreeMap<Integer, String> map = ohMy
					.collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
			System.out.println(map); // // {5=lions,bears, 6=tigers}
			System.out.println(map.getClass()); // class. java.util.TreeMap
		}
		{// MAP Collectors.groupingBy()
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
			System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		}
		{// SET Collectors.toSet()
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<Integer, Set<String>> map = ohMy.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
			System.out.println(map); // {5=[lions, bears], 6=[tigers]}
		}
		{// Collectors.partitioningBy
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<Boolean, List<String>> map = ohMy.collect(Collectors.partitioningBy(s -> s.length() <= 5));
			System.out.println(map); // {false=[tigers], true=[lions, bears]}
		}
		{
			// SET Collectors.toSet()
		}
		{
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			TreeMap<Integer, List<String>> map = ohMy
					.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
			System.out.println(map);
		}
		{
			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
			Map<Boolean, Set<String>> map = ohMy
					.collect(Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
			System.out.println(map);// {false=[], true=[lions, tigers, bears]}
		}
		{
//			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//			Map<Integer, Optional<Character>> map = ohMy.collect(Collectors.groupingBy(String::length,
//					Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
//			System.out.println(map); // {5=Optional[b], 6=Optional[t]}
		}
		{
//			Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//			Map<Integer, Optional<Character>> map = ohMy
//					.collect(groupingBy(String::length, mapping(s -> s.charAt(0), minBy(Comparator.naturalOrder()))));
//			System.out.println(map); // {5=Optional[b], 6=Optional[t]}
		}
	}

	private static void threeDigit(Optional<Integer> optional) {
		if (optional.isPresent()) { // outer if
			Integer num = optional.get();
			String string = "" + num;
			if (string.length() == 3) // inner if
				System.out.println(string);
		}
	}

	// método de cima é igual o método abaixo
	private static void threeDigitStream(Optional<Integer> optional) {
		optional.map(n -> "" + n) // part 1
				.filter(s -> s.length() == 3) // part 2
				.ifPresent(System.out::println); // part 3

	}

}
