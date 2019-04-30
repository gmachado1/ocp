package br.com.chap03;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ComputeTest {

	
	public static void main(String[] args) {
		
		{
			Map<String, Integer> counts = new HashMap<>();
			counts.put("Jenny", 1);
			
			BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
			Integer jenny = counts.computeIfPresent("Jenny", mapper);
			Integer sam = counts.computeIfPresent("Sam", mapper);
			System.out.println(counts); // {Jenny=2}
			System.out.println(jenny); // 2
			System.out.println(sam); // null
			//demonstra acima que quando nulo não é acessado,ou darianullpointerException.
		}
		{
			Map<String, Integer> counts = new HashMap<>();
			counts.put("Jenny", 15);
			counts.put("Tom", null);
			Function<String, Integer> mapper = (k) -> 1;
			Integer jenny = counts.computeIfAbsent("Jenny", mapper); // 15
			Integer sam = counts.computeIfAbsent("Sam", mapper); // 1
			Integer tom = counts.computeIfAbsent("Tom", mapper); // 1
			System.out.println(counts); // {Tom=1, Jenny=15, Sam=1}
		}
		{
			Map<String, Integer> counts = new HashMap<>();
			counts.put("Jenny", 1);
			counts.computeIfPresent("Jenny", (k, v) -> null);
			counts.computeIfAbsent("Sam", k -> null);
			System.out.println(counts); // {}
		}
		{
			
		}
	}
}
