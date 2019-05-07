package br.com.patternsAndPrinciples.funcionalPrograming;

import java.util.function.Predicate;

public class FindMatchingAnimal {

	private static void print(Animal a, CheckTrait trait) {
		if (trait.test(a)) {
			System.out.println("can swim - print method");
			System.out.println(a);
		}
	}
	private static void printWithPredicate(Animal a, Predicate<Animal> trait) {
		if (trait.test(a)) {
			System.out.println("can hop - printWithPredicate method");
			System.out.println(a);
		}
	}

	public static void main(String args[]) {
		print(new Animal("turtle", false, true), a -> a.isCanSwim());
		print(new Animal("kangoroo", true, false), a -> a.isCanSwim());
		
		printWithPredicate(new Animal("turtle", false, true), a -> a.isCanHop());
		printWithPredicate(new Animal("kangoroo", true, false), a -> a.isCanHop());
	}
}
