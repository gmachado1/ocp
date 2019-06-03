package br.com.functionalProgramming.functionalInterface;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ReturningOptinal {
	public static void main(String[] args) {
		{
			Optional<Double> opt = average(90, 100);
			System.out.println(average()); // Optional.empty

			if (opt.isPresent())
				System.out.println(opt.get()); // 95.0

			try {
				System.out.println(opt.get()); // bad
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		{
			Optional<Double> opt = average(90, 100);
			opt.ifPresent(System.out::println);
		}
		{
			Optional<Double> opt = average();
			System.out.println(opt.orElse(Double.NaN));
			System.out.println(opt.orElseGet(() -> Math.random()));
			System.out.println(opt.orElseThrow(() -> new IllegalStateException()));
		}
		{
			
		}
	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}
}
