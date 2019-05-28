package br.com.classDesign.exam;

public class FlavorsEnum {
	enum Flavors {
		VANILLA, CHOCOLATE, STRAWBERRY;
	}

	public static void main(String[] args) {
		System.out.println(Flavors.CHOCOLATE.ordinal());
	}
}
