package br.com.classDesign.nestedClasses;

public class Enclosing {
	static class Nested {
		private static int qtd = 1;
		private int price = 6 * qtd;
	}

	public static void main(String[] args) {
		Nested nested = new Nested();
		System.out.println(nested.price);
		System.out.println(Nested.qtd);
	}
}
