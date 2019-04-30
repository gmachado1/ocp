package br.com.chap03;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ListsToTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();// HASHMAP not sorted
		map.put("koala", "bamboo");
		map.put("lion", "meat");
		map.put("giraffe", "leaf");
		String food = map.get("koala"); // bamboo
		for (String key : map.keySet())
			System.out.print(key + ","); // koala,giraffe,lion,

		System.out.println("\n\nTREEMAP\n");
		/*
		 * TreeMap sorts the keys as we would expect. If we were to have called values()
		 * instead of keySet(), the order of the values would correspond to the order of
		 * the keys.
		 */
		Map<String, String> mapt = new TreeMap<>();
		mapt.put("koala", "bamboo");
		mapt.put("lion", "meat");
		mapt.put("giraffe", "leaf");
		String foodt = map.get("koala"); // bamboo
		for (String keyt : mapt.keySet())
			System.out.print(keyt + ","); // giraffe,koala,lion,
	}
}