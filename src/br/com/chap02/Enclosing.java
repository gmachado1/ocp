package br.com.chap02;

public class Enclosing {
	static class Nested {
		private int price = 6;
		private static int prices = 7;
	}

	public static void main(String[] args) {
		Nested nested = new Nested();
		System.out.println(nested.price);
		System.out.println(Nested.prices);
	}
}
