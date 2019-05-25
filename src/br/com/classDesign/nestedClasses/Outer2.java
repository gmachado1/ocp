package br.com.classDesign.nestedClasses;

public class Outer2 {
	private int length = 5;

	public void calculate() {
		final int width = 20;
		 class Inner {
			public void multiply() {
				System.out.println(length * width);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}

	public static void main(String[] args) {
		Outer2 Outer2 = new Outer2();
		Outer2.calculate();
	}
}
