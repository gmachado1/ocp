package br.com.genericsAndCollections.newJava8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Java8newFunc {

	public static void main(String[] args) {
		{
			System.out.println("\n MAPS");
			Map<String, String> favorites = new HashMap<>();
			favorites.put("Jenny", "Bus Tour");
			favorites.put("Jenny", "Tram");
			System.out.println(favorites); // {Jenny=Tram} Jenny was updated

			favorites.put("Tom", null);
			System.out.println(favorites);
			favorites.putIfAbsent("Jenny", "Tram");// is not updated
			favorites.putIfAbsent("Sam", "Tram");
			favorites.putIfAbsent("Tom", "Tram");// tom is update because is null value
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
