package br.com.functionalProgramming.functionalInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTesting {

	public static void main(String[] args) {
		{
			Map<String, Integer> map = new HashMap<>();
			BiConsumer<String, Integer> b1 = map::put;
			BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
			b1.accept("chicken", 7);
			b2.accept("chick", 1);
			System.out.println(map);
		}
		{
			Map<String, String> map = new HashMap<>();
			BiConsumer<String, String> b1 = map::put;
			BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);
			b1.accept("chicken", "Cluck");
			b2.accept("chick", "Tweep");
			System.out.println(map);
		}
	}
}
