package br.com.genericsAndCollections;

import java.util.*;
import java.util.function.BiFunction;

public class SortRabbits {
	static class Rabbit {
		int id;
	}

	public static void main(String[] args) {
		{
			List<Rabbit> rabbits = new ArrayList<>();
			rabbits.add(new Rabbit());
			Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
			Collections.sort(rabbits, c);
		}
		{
			List<String> list = new ArrayList<String>();
			list.add("Abobora");
			list.add("Cogumelo");
			System.out.println(list);
			list.removeIf(s -> s.startsWith("A"));
			System.out.println(list);
		}
		{
			List<Integer> list = Arrays.asList(1, 2, 3);
			list.replaceAll(x -> x * 2);
			System.out.println(list); // [2, 4, 6]
		}
		{
			List<String> cats = Arrays.asList("Annie", "Ripley");
			for (String cat : cats)
				System.out.print(" " + cat);
			// ou
			System.out.println();
			cats.forEach(c -> System.out.print(" " + c));
			System.out.println();
			// ou
			cats.forEach(System.out::print);
		}
		{
			System.out.println("\n MAPS");
			Map<String, String> favorites = new HashMap<>();
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Jenny", "Tram");
			System.out.println(favorites); // {Jenny=Tram}

			favorites.put("Tom", null);
			System.out.println(favorites);
			favorites.putIfAbsent("Jenny", "Tram");
			favorites.putIfAbsent("Sam", "Tram");
			favorites.putIfAbsent("Tom", "Tram");
			System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}
		}
		{
			System.out.println("\n\n BiFunction");
			BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;

			Map<String, String> favorites = new HashMap<>();
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Tom", "Tram");

			String jenny = favorites.merge("Jenny", "Skyride", mapper);
			String tom = favorites.merge("Tom", "Skyride", mapper);

			System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
			System.out.println(jenny); // Bus Tour
			System.out.println(tom); // Skyride
		}
		{
			System.out.println("\n\n BiFunction2");
			BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
			Map<String, String> favorites = new HashMap<>();
			favorites.put("Sam", null);
			favorites.merge("Tom", "Skyride", mapper);
			favorites.merge("Sam", "Skyride", mapper);
			System.out.println(favorites); // {Tom=Skyride, Sam=Skyride}
		}

		{
			System.out.println("\n\n BiFunction3");
			BiFunction<String, String, String> mapper = (v1, v2) -> null;
			Map<String, String> favorites = new HashMap<>();
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Tom", "Bus Tour");
			favorites.merge("Jenny", "Skyride", mapper);
			favorites.merge("Sam", "Skyride", mapper);
			System.out.println(favorites); // {Tom=Bus Tour, Sam=Skyride}
		}
	}
}
